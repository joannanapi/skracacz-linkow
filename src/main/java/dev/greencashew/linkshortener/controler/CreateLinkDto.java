package dev.greencashew.linkshortener.controler;

record CreateLinkDto (
    String id,
    String email,
    String targetUrl,
   String  explorationDate)
    {
    public LinkDto toDto() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                explorationDate,
                0
        );
    }
}
