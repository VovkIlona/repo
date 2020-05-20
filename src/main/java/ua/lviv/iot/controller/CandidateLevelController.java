package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.CandidateLevelDTO;
import ua.lviv.iot.domain.CandidateLevel;
import ua.lviv.iot.service.CandidateLevelService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/candidate_level")
public class CandidateLevelController {

    @Autowired
    CandidateLevelService candidateLevelService;

    @GetMapping
    public ResponseEntity<List<CandidateLevelDTO>> getAllCandidateLevel() throws Exception {
        List<CandidateLevel> candidateLevelList = candidateLevelService.getAllCandidateLevel();
        Link link = linkTo(methodOn(CandidateLevelController.class).getAllCandidateLevel()).withSelfRel();

        List<CandidateLevelDTO> candidateLevelDTOList = new ArrayList<>();

        for (CandidateLevel entity : candidateLevelList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CandidateLevelDTO dto = new CandidateLevelDTO(entity, selfLink);
            candidateLevelDTOList.add(dto);

        }

        return new ResponseEntity<>(candidateLevelDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{candidate_level_id}")
    public ResponseEntity<CandidateLevelDTO> getCandidateLevel(@PathVariable Integer candidate_level_id) throws Exception {
        CandidateLevel candidateLevel = candidateLevelService.getCandidateLevel(candidate_level_id);
        Link link = linkTo(methodOn(CandidateLevelController.class).getCandidateLevel(candidate_level_id)).withSelfRel();

        CandidateLevelDTO candidateLevelDTO = new CandidateLevelDTO(candidateLevel, link);

        return new ResponseEntity<>(candidateLevelDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CandidateLevelDTO> addCandidateLevel(@RequestBody CandidateLevel candidateLevel) throws Exception {
        candidateLevelService.createCandidateLevel(candidateLevel);
        Link link = linkTo(methodOn(CandidateLevelController.class).getCandidateLevel(candidateLevel.getId())).withSelfRel();

        CandidateLevelDTO candidateLevelDTO = new CandidateLevelDTO(candidateLevel, link);

        return new ResponseEntity<>(candidateLevelDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{candidate_level_id}")
    public ResponseEntity<CandidateLevelDTO> updateCandidateLevel(@RequestBody CandidateLevel uCandidateLevel, @PathVariable Integer candidate_level_id) throws Exception {
        candidateLevelService.updateCandidateLevel(uCandidateLevel, candidate_level_id);
        CandidateLevel candidateLevel = candidateLevelService.getCandidateLevel(candidate_level_id);
        Link link = linkTo(methodOn(CandidateLevelController.class).getCandidateLevel(candidate_level_id)).withSelfRel();

        CandidateLevelDTO candidateLevelDTO = new CandidateLevelDTO(candidateLevel, link);

        return new ResponseEntity<>(candidateLevelDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{candidate_level_id}")
    public ResponseEntity deleteCandidateLevel(@PathVariable Integer candidate_level_id) throws Exception {
        candidateLevelService.deleteCandidateLevel(candidate_level_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
