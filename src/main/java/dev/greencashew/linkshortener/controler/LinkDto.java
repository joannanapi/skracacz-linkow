package dev.greencashew.linkshortener.controler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

public record LinkDto(String id, String email, String targetUrl, LocalDate expirationDate, int visits) {

    public String getShortenedLink() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/s/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}
