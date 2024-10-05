package tri.novica.interactions.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tri.novica.interactions.dto.interaction.CreateInteractionCmd;
import tri.novica.interactions.dto.interaction.InteractionInfo;
import tri.novica.interactions.service.InteractionService;

import java.util.List;

@RestController
@RequestMapping("/interactions")
@RequiredArgsConstructor
public class InteractionController {

    private final InteractionService interactionService;

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<InteractionInfo> findAll(){
        return interactionService.findAll();
    }

    @GetMapping("{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public InteractionInfo findById(@PathVariable Long id){
        return interactionService.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public InteractionInfo createInteraction(@RequestBody CreateInteractionCmd interactionCmd){
        return interactionService.createInteraction(interactionCmd);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        interactionService.deleteById(id);
    }
}
