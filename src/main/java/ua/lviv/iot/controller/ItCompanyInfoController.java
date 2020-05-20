package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.ItCompanyInfoDTO;
import ua.lviv.iot.domain.ItCompanyInfo;

import ua.lviv.iot.service.ItCompanyInfoService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/it_company_info")
public class ItCompanyInfoController {

    @Autowired
    ItCompanyInfoService service;

    @GetMapping
    public ResponseEntity<List<ItCompanyInfoDTO>> getAllItCompanyInfo() throws Exception {
        List<ItCompanyInfo> ItCompanyInfoList = service.getAllItCompanyInfo();
        Link link = linkTo(methodOn(ItCompanyInfoController.class).getAllItCompanyInfo()).withSelfRel();

        List<ItCompanyInfoDTO> ItCompanyInfoDTOList = new ArrayList<>();

        for (ItCompanyInfo entity : ItCompanyInfoList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ItCompanyInfoDTO dto = new ItCompanyInfoDTO(entity, selfLink);
            ItCompanyInfoDTOList.add(dto);

        }

        return new ResponseEntity<>(ItCompanyInfoDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{it_company_info_id}")
    public ResponseEntity<ItCompanyInfoDTO> getItCompanyInfo(@PathVariable Integer it_company_info_id) throws Exception {
        ItCompanyInfo ItCompanyInfo = service.getItCompanyInfo(it_company_info_id);
        Link link = linkTo(methodOn(ItCompanyInfoController.class).getItCompanyInfo(it_company_info_id)).withSelfRel();

        ItCompanyInfoDTO ItCompanyInfoDTO = new ItCompanyInfoDTO(ItCompanyInfo, link);

        return new ResponseEntity<>(ItCompanyInfoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItCompanyInfoDTO> addItCompanyInfo(@RequestBody ItCompanyInfo ItCompanyInfo) throws Exception {
        service.createItCompanyInfo(ItCompanyInfo);
        Link link = linkTo(methodOn(ItCompanyInfoController.class).getItCompanyInfo(ItCompanyInfo.getId())).withSelfRel();

        ItCompanyInfoDTO ItCompanyInfoDTO = new ItCompanyInfoDTO(ItCompanyInfo, link);

        return new ResponseEntity<>(ItCompanyInfoDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{it_company_info_id}")
    public ResponseEntity<ItCompanyInfoDTO> updateItCompanyInfo(@RequestBody ItCompanyInfo uItCompanyInfo, @PathVariable Integer it_company_info_id) throws Exception {
        service.updateItCompanyInfo(uItCompanyInfo, it_company_info_id);
        ItCompanyInfo ItCompanyInfo = service.getItCompanyInfo(it_company_info_id);
        Link link = linkTo(methodOn(ItCompanyInfoController.class).getItCompanyInfo(it_company_info_id)).withSelfRel();

        ItCompanyInfoDTO ItCompanyInfoDTO = new ItCompanyInfoDTO(ItCompanyInfo, link);

        return new ResponseEntity<>(ItCompanyInfoDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{it_company_info_id}")
    public ResponseEntity deleteItCompanyInfo(@PathVariable Integer it_company_info_id) throws Exception {
        service.deleteItCompanyInfo(it_company_info_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
