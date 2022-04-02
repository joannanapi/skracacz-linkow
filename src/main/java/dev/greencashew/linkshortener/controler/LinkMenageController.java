package dev.greencashew.linkshortener.controler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/links")
@ResponseStatus(HttpStatus.CREATED)
public class LinkMenageController {
    LinkDto createLink(@RequestBody CreateLinkDto link){
        return link.toDto();
    }




}
