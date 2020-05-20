package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.VacancyInfoDTO;
import ua.lviv.iot.domain.VacancyInfo;
import ua.lviv.iot.service.VacancyInfoService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/vacancy_info")
public class VacancyInfoController {

    @Autowired
    VacancyInfoService service;

    @GetMapping
    public ResponseEntity<List<VacancyInfoDTO>> getAllVacancyInfo() throws Exception {
        List<VacancyInfo> VacancyInfoList = service.getAllVacancyInfo();
        Link link = linkTo(methodOn(VacancyInfoController.class).getAllVacancyInfo()).withSelfRel();

        List<VacancyInfoDTO> VacancyInfoDTOList = new ArrayList<>();

        for (VacancyInfo entity : VacancyInfoList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            VacancyInfoDTO dto = new VacancyInfoDTO(entity, selfLink);
            VacancyInfoDTOList.add(dto);

        }

        return new ResponseEntity<>(VacancyInfoDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{vacancy_info_id}")
    public ResponseEntity<VacancyInfoDTO> getVacancyInfo(@PathVariable Integer vacancy_info_id) throws Exception {
        VacancyInfo VacancyInfo = service.getVacancyInfo(vacancy_info_id);
        Link link = linkTo(methodOn(VacancyInfoController.class).getVacancyInfo(vacancy_info_id)).withSelfRel();

        VacancyInfoDTO VacancyInfoDTO = new VacancyInfoDTO(VacancyInfo, link);

        return new ResponseEntity<>(VacancyInfoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VacancyInfoDTO> addVacancyInfo(@RequestBody VacancyInfo VacancyInfo) throws Exception {
        service.createVacancyInfo(VacancyInfo);
        Link link = linkTo(methodOn(VacancyInfoController.class).getVacancyInfo(VacancyInfo.getId())).withSelfRel();

        VacancyInfoDTO VacancyInfoDTO = new VacancyInfoDTO(VacancyInfo, link);

        return new ResponseEntity<>(VacancyInfoDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{vacancy_info_id}")
    public ResponseEntity<VacancyInfoDTO> updateVacancyInfo(@RequestBody VacancyInfo uVacancyInfo, @PathVariable Integer vacancy_info_id) throws Exception {
        service.updateVacancyInfo(uVacancyInfo, vacancy_info_id);
        VacancyInfo VacancyInfo = service.getVacancyInfo(vacancy_info_id);
        Link link = linkTo(methodOn(VacancyInfoController.class).getVacancyInfo(vacancy_info_id)).withSelfRel();

        VacancyInfoDTO VacancyInfoDTO = new VacancyInfoDTO(VacancyInfo, link);

        return new ResponseEntity<>(VacancyInfoDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{vacancy_info_id}")
    public ResponseEntity deleteVacancyInfo(@PathVariable Integer vacancy_info_id) throws Exception {
        service.deleteVacancyInfo(vacancy_info_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
