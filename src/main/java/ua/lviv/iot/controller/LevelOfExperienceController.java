package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.LevelOfExperienceDTO;
import ua.lviv.iot.domain.LevelOfExperience;
import ua.lviv.iot.service.LevelOfExperienceService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/level_of_experience")
public class LevelOfExperienceController {

    @Autowired
    LevelOfExperienceService service;

    @GetMapping
    public ResponseEntity<List<LevelOfExperienceDTO>> getAllLevelOfExperience() throws Exception {
        List<LevelOfExperience> LevelOfExperienceList = service.getAllLevelOfExperience();
        Link link = linkTo(methodOn(LevelOfExperienceController.class).getAllLevelOfExperience()).withSelfRel();

        List<LevelOfExperienceDTO> LevelOfExperienceDTOList = new ArrayList<>();

        for (LevelOfExperience entity : LevelOfExperienceList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            LevelOfExperienceDTO dto = new LevelOfExperienceDTO(entity, selfLink);
            LevelOfExperienceDTOList.add(dto);

        }

        return new ResponseEntity<>(LevelOfExperienceDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{level_of_experience_id}")
    public ResponseEntity<LevelOfExperienceDTO> getLevelOfExperience(@PathVariable Integer level_of_experience_id) throws Exception {
        LevelOfExperience LevelOfExperience = service.getLevelOfExperience(level_of_experience_id);
        Link link = linkTo(methodOn(LevelOfExperienceController.class).getLevelOfExperience(level_of_experience_id)).withSelfRel();

        LevelOfExperienceDTO LevelOfExperienceDTO = new LevelOfExperienceDTO(LevelOfExperience, link);

        return new ResponseEntity<>(LevelOfExperienceDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LevelOfExperienceDTO> addLevelOfExperience(@RequestBody LevelOfExperience LevelOfExperience) throws Exception {
        service.createLevelOfExperience(LevelOfExperience);
        Link link = linkTo(methodOn(LevelOfExperienceController.class).getLevelOfExperience(LevelOfExperience.getId())).withSelfRel();

        LevelOfExperienceDTO LevelOfExperienceDTO = new LevelOfExperienceDTO(LevelOfExperience, link);

        return new ResponseEntity<>(LevelOfExperienceDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{level_of_experience_id}")
    public ResponseEntity<LevelOfExperienceDTO> updateLevelOfExperience(@RequestBody LevelOfExperience uLevelOfExperience, @PathVariable Integer level_of_experience_id) throws Exception {
        service.updateLevelOfExperience(uLevelOfExperience, level_of_experience_id);
        LevelOfExperience LevelOfExperience = service.getLevelOfExperience(level_of_experience_id);
        Link link = linkTo(methodOn(LevelOfExperienceController.class).getLevelOfExperience(level_of_experience_id)).withSelfRel();

        LevelOfExperienceDTO LevelOfExperienceDTO = new LevelOfExperienceDTO(LevelOfExperience, link);

        return new ResponseEntity<>(LevelOfExperienceDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{level_of_experience_id}")
    public ResponseEntity deleteLevelOfExperience(@PathVariable Integer level_of_experience_id) throws Exception {
        service.deleteLevelOfExperience(level_of_experience_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
