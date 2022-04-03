package dev.greencashew.linkshortener.controler;

import dev.greencashew.linkshortener.link.LinkDto;
import dev.greencashew.linkshortener.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/s")
public class RedirectController {
    private final LinkService service;

    @Autowired
    public RedirectController(LinkService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<?> redirectLink(
            @PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        // LinkDto dto =  service.getLink(id);
      //  Optional<LinkDto> dtoOptional = Optional.ofNullable(null);
       final LinkDto dto = service.getLink(id);
        if (dto != null) {
            httpServletResponse.sendRedirect(dto.targetUrl());
            return ResponseEntity.ok().build();
            //httpServletResponse.sendRedirect(dto.getShortenedLink());
        } else {
            return  ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ExceptionResponse("Linku nie znaleziono"));

        }
    }
}