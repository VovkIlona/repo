package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.TechnicalLevelDTO;
import ua.lviv.iot.domain.TechnicalLevel;
import ua.lviv.iot.service.TechnicalLevelService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/technical_level")
public class TechnicalLevelController {

    @Autowired
    TechnicalLevelService service;

    @GetMapping
    public ResponseEntity<List<TechnicalLevelDTO>> getAllTechnicalLevel() throws Exception {
        List<TechnicalLevel> TechnicalLevelList = service.getAllTechnicalLevel();
        Link link = linkTo(methodOn(TechnicalLevelController.class).getAllTechnicalLevel()).withSelfRel();

        List<TechnicalLevelDTO> TechnicalLevelDTOList = new ArrayList<>();

        for (TechnicalLevel entity : TechnicalLevelList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            TechnicalLevelDTO dto = new TechnicalLevelDTO(entity, selfLink);
            TechnicalLevelDTOList.add(dto);

        }

        return new ResponseEntity<>(TechnicalLevelDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{technical_level_id}")
    public ResponseEntity<TechnicalLevelDTO> getTechnicalLevel(@PathVariable Integer technical_level_id) throws Exception {
        TechnicalLevel TechnicalLevel = service.getTechnicalLevel(technical_level_id);
        Link link = linkTo(methodOn(TechnicalLevelController.class).getTechnicalLevel(technical_level_id)).withSelfRel();

        TechnicalLevelDTO TechnicalLevelDTO = new TechnicalLevelDTO(TechnicalLevel, link);

        return new ResponseEntity<>(TechnicalLevelDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TechnicalLevelDTO> addTechnicalLevel(@RequestBody TechnicalLevel TechnicalLevel) throws Exception {
        service.createTechnicalLevel(TechnicalLevel);
        Link link = linkTo(methodOn(TechnicalLevelController.class).getTechnicalLevel(TechnicalLevel.getId())).withSelfRel();

        TechnicalLevelDTO TechnicalLevelDTO = new TechnicalLevelDTO(TechnicalLevel, link);

        return new ResponseEntity<>(TechnicalLevelDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{technical_level_id}")
    public ResponseEntity<TechnicalLevelDTO> updateTechnicalLevel(@RequestBody TechnicalLevel uTechnicalLevel, @PathVariable Integer technical_level_id) throws Exception {
        service.updateTechnicalLevel(uTechnicalLevel, technical_level_id);
        TechnicalLevel TechnicalLevel = service.getTechnicalLevel(technical_level_id);
        Link link = linkTo(methodOn(TechnicalLevelController.class).getTechnicalLevel(technical_level_id)).withSelfRel();

        TechnicalLevelDTO TechnicalLevelDTO = new TechnicalLevelDTO(TechnicalLevel, link);

        return new ResponseEntity<>(TechnicalLevelDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{technical_level_id}")
    public ResponseEntity deleteTechnicalLevel(@PathVariable Integer technical_level_id) throws Exception {
        service.deleteTechnicalLevel(technical_level_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
