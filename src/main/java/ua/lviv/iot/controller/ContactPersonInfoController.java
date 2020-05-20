package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.ContactPersonInfoDTO;
import ua.lviv.iot.domain.ContactPersonInfo;
import ua.lviv.iot.service.ContactPersonInfoService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/contact_person_info")
public class ContactPersonInfoController {

    @Autowired
    ContactPersonInfoService contactPersonInfoService = new ContactPersonInfoService();

    @GetMapping
    public ResponseEntity<List<ContactPersonInfoDTO>> getAllContactPersonsInfo() throws Exception {
        List<ContactPersonInfo> contactPersonInfoList = contactPersonInfoService.getAllContactPersonInfo();
        Link link = linkTo(methodOn(ContactPersonInfoController.class).getAllContactPersonsInfo()).withSelfRel();

        List<ContactPersonInfoDTO> contactPersonInfoDTOList = new ArrayList<>();

        for (ContactPersonInfo entity : contactPersonInfoList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ContactPersonInfoDTO dto = new ContactPersonInfoDTO(entity, selfLink);
            contactPersonInfoDTOList.add(dto);
        }

        return new ResponseEntity<>(contactPersonInfoDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{contact_person_info_id}")
    public ResponseEntity<ContactPersonInfoDTO> getContactPersonsInfo(@PathVariable Integer contact_person_info_id) throws Exception {
        ContactPersonInfo contactPersonInfo = contactPersonInfoService.getContactPersonInfo(contact_person_info_id);
        Link link = linkTo(methodOn(ContactPersonInfoController.class).getContactPersonsInfo(contact_person_info_id)).withSelfRel();

        ContactPersonInfoDTO contactPersonInfoDTO = new ContactPersonInfoDTO(contactPersonInfo, link);

        return new ResponseEntity<>(contactPersonInfoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactPersonInfoDTO> addContactPersonInfo(@RequestBody ContactPersonInfo ContactPersonInfo) throws Exception {
        contactPersonInfoService.createContactPersonInfo(ContactPersonInfo);
        Link link = linkTo(methodOn(ContactPersonInfoController.class).getContactPersonsInfo(ContactPersonInfo.getId())).withSelfRel();

        ContactPersonInfoDTO ContactPersonInfoDTO = new ContactPersonInfoDTO(ContactPersonInfo, link);

        return new ResponseEntity<>(ContactPersonInfoDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{contact_person_info_id}")
    public ResponseEntity<ContactPersonInfoDTO> updateContactPersonInfo(@RequestBody ContactPersonInfo uContactPersonInfo, @PathVariable Integer contact_person_info_id) throws Exception {
        contactPersonInfoService.updateContactPersonInfo(uContactPersonInfo, contact_person_info_id);
        ContactPersonInfo ContactPersonInfo = contactPersonInfoService.getContactPersonInfo(contact_person_info_id);
        Link link = linkTo(methodOn(ContactPersonInfoController.class).getContactPersonsInfo(contact_person_info_id)).withSelfRel();

        ContactPersonInfoDTO ContactPersonInfoDTO = new ContactPersonInfoDTO(ContactPersonInfo, link);

        return new ResponseEntity<>(ContactPersonInfoDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{contact_person_info_id}")
    public ResponseEntity deleteContactPersonInfo(@PathVariable Integer contact_person_info_id) throws Exception {
        contactPersonInfoService.deleteContactPersonInfo(contact_person_info_id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
