package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.LanguageDTO;
import ua.lviv.iot.domain.Language;
import ua.lviv.iot.service.LanguageService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService service;

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> getAllLanguage() throws Exception {
        List<Language> LanguageList = service.getAllLanguage();
        Link link = linkTo(methodOn(LanguageController.class).getAllLanguage()).withSelfRel();

        List<LanguageDTO> LanguageDTOList = new ArrayList<>();

        for (Language entity : LanguageList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            LanguageDTO dto = new LanguageDTO(entity, selfLink);
            LanguageDTOList.add(dto);

        }

        return new ResponseEntity<>(LanguageDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{language_id}")
    public ResponseEntity<LanguageDTO> getLanguage(@PathVariable Integer language_id) throws Exception {
        Language Language = service.getLanguage(language_id);
        Link link = linkTo(methodOn(LanguageController.class).getLanguage(language_id)).withSelfRel();

        LanguageDTO LanguageDTO = new LanguageDTO(Language, link);

        return new ResponseEntity<>(LanguageDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LanguageDTO> addLanguage(@RequestBody Language Language) throws Exception {
        service.createLanguage(Language);
        Link link = linkTo(methodOn(LanguageController.class).getLanguage(Language.getId())).withSelfRel();

        LanguageDTO LanguageDTO = new LanguageDTO(Language, link);

        return new ResponseEntity<>(LanguageDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{language_id}")
    public ResponseEntity<LanguageDTO> updateLanguage(@RequestBody Language uLanguage, @PathVariable Integer language_id) throws Exception {
        service.updateLanguage(uLanguage, language_id);
        Language Language = service.getLanguage(language_id);
        Link link = linkTo(methodOn(LanguageController.class).getLanguage(language_id)).withSelfRel();

        LanguageDTO LanguageDTO = new LanguageDTO(Language, link);

        return new ResponseEntity<>(LanguageDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{language_id}")
    public ResponseEntity deleteLanguage(@PathVariable Integer language_id) throws Exception {
        service.deleteLanguage(language_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
