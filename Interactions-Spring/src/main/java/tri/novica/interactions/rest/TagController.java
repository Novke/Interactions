package tri.novica.interactions.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tri.novica.interactions.dto.CreateTagCmd;
import tri.novica.interactions.dto.TagInfo;
import tri.novica.interactions.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<TagInfo> getAll(){
        return tagService.findAll();
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public TagInfo create(@RequestBody CreateTagCmd tagCmd){
        return tagService.createTag(tagCmd);
    }

    @DeleteMapping("/{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteByName(@PathVariable String name){
        tagService.deleteTag(name);
    }

}
