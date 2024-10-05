package tri.novica.interactions.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tri.novica.interactions.dto.CreateTagCmd;
import tri.novica.interactions.dto.TagInfo;
import tri.novica.interactions.entity.TagEntity;
import tri.novica.interactions.exceptions.EntityNotFoundException;
import tri.novica.interactions.repository.TagRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService {
    
    private final TagRepository tagRepository;
    private final ModelMapper mapper;

    public List<TagInfo> findAll() {
        return tagRepository.findAll()
                .stream()
                .map(tag -> mapper.map(tag, TagInfo.class))
                .toList();
    }

    public TagInfo createTag(CreateTagCmd tagCmd){
        tagCmd.setName(tagCmd.getName().toUpperCase());

        return mapper.map(
                tagRepository.save(mapper.map(tagCmd, TagEntity.class)),
                TagInfo.class);
    }

    public void deleteTag(String tagname){
        TagEntity tag = tagRepository.findByName(tagname)
                .orElseThrow(() -> new EntityNotFoundException("Tag with name " + tagname + " does not exist"));
        tagRepository.delete(tag);
    }
}
