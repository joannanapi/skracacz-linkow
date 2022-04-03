package dev.greencashew.linkshortener.controler;

import dev.greencashew.linkshortener.link.LinkAlreadyExistsException;
import dev.greencashew.linkshortener.link.LinkDto;
import dev.greencashew.linkshortener.link.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/links")
public class LinkMenageController {
private final LinkService service;

LinkMenageController(LinkService service){
    this.service = service;
}
    @PostMapping
   // @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createLink(@RequestBody CreateLinkDto link) {
        try {
            LinkDto linkDto = link.toDto();
            return ResponseEntity
                    .created(URI.create(linkDto.getShortenedLink()))
                    .body(service.createLink(linkDto));
        } catch (LinkAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ExceptionResponse(e.getMessage()));
        }

    }
//    LinkDto createLink(@RequestBody CreateLinkDto link){
//        try{
//            return service.
//        }
//        return service.createLink(link.toDto());
//    }
    @DeleteMapping("/{id}/{email}")
//    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> deleteLink(String id, String email){
        return ResponseEntity.noContent().build();
}
}
