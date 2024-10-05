package tri.novica.interactions.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tri.novica.interactions.dto.interaction.CreateInteractionCmd;
import tri.novica.interactions.dto.interaction.InteractionInfo;
import tri.novica.interactions.entity.InteractionEntity;
import tri.novica.interactions.entity.PersonEntity;
import tri.novica.interactions.entity.TagEntity;
import tri.novica.interactions.exceptions.EntityNotFoundException;
import tri.novica.interactions.repository.InteractionRepository;
import tri.novica.interactions.repository.PersonRepository;
import tri.novica.interactions.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InteractionService {

    private final InteractionRepository interactionRepository;
    private final PersonRepository personRepository;
    private final TagRepository tagRepository;
    private final ModelMapper mapper;

    public List<InteractionInfo> findAll() {
        return interactionRepository.findAll()
                .stream()
                .map(i -> mapper.map(i, InteractionInfo.class))
                .toList();
    }

    public InteractionInfo findById(Long id) {
        InteractionEntity interaction = interactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Interaction not found"));
        return mapper.map(interaction, InteractionInfo.class);
    }

    public InteractionInfo createInteraction(CreateInteractionCmd interactionCmd) {
        InteractionEntity interactionEntity = mapper.map(interactionCmd, InteractionEntity.class);

        setPersons(interactionEntity);
        setTags(interactionEntity);

        return mapper.map(interactionRepository.save(interactionEntity), InteractionInfo.class);
    }

    public void deleteById(Long id) {
        findById(id);
        interactionRepository.deleteById(id);
    }

    private void setPersons(InteractionEntity interactionEntity) {
        List<PersonEntity> personEntities = new ArrayList<>();
        interactionEntity.getPersons().forEach(
                person -> {
                    personEntities.add(personRepository.findById(person.getId())
                            .orElseThrow(() -> new EntityNotFoundException("Person not found! ID: " + person.getId())));
                });
        interactionEntity.setPersons(personEntities);
    }

    private void setTags(InteractionEntity interactionEntity) {
        List<TagEntity> tagEntities = new ArrayList<>();
        interactionEntity.getTags().forEach(
                tag -> {
                    final Long id = tag.getId();
                    if (id != null) {
                        tag = tagRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Tag not found! ID: " + id));
                    } else {
                        final String name = tag.getName();
                        if (name != null && !name.isBlank()){
                            tag = tagRepository.findByName(name).orElse(tag);
                        }
                    }
                    tagEntities.add(tag);
                });
        interactionEntity.setTags(tagEntities);
    }

}
