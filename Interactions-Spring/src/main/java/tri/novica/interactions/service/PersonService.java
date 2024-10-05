package tri.novica.interactions.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tri.novica.interactions.dto.CreatePersonCmd;
import tri.novica.interactions.dto.PersonInfo;
import tri.novica.interactions.entity.PersonEntity;
import tri.novica.interactions.exceptions.EntityNotFoundException;
import tri.novica.interactions.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper mapper;

    public List<PersonInfo> findAll() {
        return personRepository.findAll()
                .stream()
                .map(person -> mapper.map(person, PersonInfo.class))
                .toList();
    }

    public PersonInfo findById(Long id) {
        PersonEntity person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person does not exist"));
        return mapper.map(person, PersonInfo.class);
    }

    public PersonInfo createPerson(CreatePersonCmd personCmd) {
        return mapper.map(
          personRepository.save(mapper.map(personCmd, PersonEntity.class)),
          PersonInfo.class
        );
    }

    public void deleteById(Long id) {
        findById(id);
        personRepository.deleteById(id);
    }
}
