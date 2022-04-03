package dev.greencashew.linkshortener.link;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class LinkServiceImpl implements LinkService {
    private Map<String, LinkDto> repository = new HashMap<>();

//    private Map<String, LinkDto> repository;
//    public LinkServiceImpl(){
//        this.repository = new HashMap<>();
//    }

    @Override
    public LinkDto createLink(LinkDto dto)throws LinkAlreadyExistsException {
        if (repository.containsKey(dto.id())) {
            throw new LinkAlreadyExistsException(dto.id());
        }
        repository.put(dto.id(), dto);
        return dto;
    }

    @Override
    public LinkDto getLink(String id) {
        return repository.get(id);
    }


    //throw new RuntimeException("RUNTIME EXCEPTION");
     //   repository.put(dto.id(), dto);
    //    return null;

}
