package tri.novica.interactions.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tri.novica.interactions.dto.CreatePersonCmd;
import tri.novica.interactions.dto.PersonInfo;
import tri.novica.interactions.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<PersonInfo> findAll(){
        return personService.findAll();
    }
    @GetMapping("{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PersonInfo findById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PersonInfo createPerson(@RequestBody CreatePersonCmd personCmd){
        return personService.createPerson(personCmd);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }

}
