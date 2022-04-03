package dev.greencashew.linkshortener.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkMenageController {

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link){
        return link.toDto();
    }
//    @DeleteMapping("/{id}/{email}")
//    @ResponseStatus(HttpStatus.OK)
//    ResponseEntity<?> deleteLink(String id, String email){
//        return ResponseEntity.noContent().build();
//}
}
