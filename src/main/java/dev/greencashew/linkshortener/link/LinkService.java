package dev.greencashew.linkshortener.link;

public interface LinkService {
    LinkDto createLink(LinkDto dto);

    LinkDto getLink(String id);
}
