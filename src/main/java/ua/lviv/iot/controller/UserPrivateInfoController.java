package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.UserPrivateInfoDTO;
import ua.lviv.iot.domain.UserPrivateInfo;
import ua.lviv.iot.service.UserPrivateInfoService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/user_private_info")
public class UserPrivateInfoController {

    @Autowired
    UserPrivateInfoService service;

    @GetMapping
    public ResponseEntity<List<UserPrivateInfoDTO>> getAllUserPrivateInfo() throws Exception {
        List<UserPrivateInfo> UserPrivateInfoList = service.getAllUserPrivateInfo();
        Link link = linkTo(methodOn(UserPrivateInfoController.class).getAllUserPrivateInfo()).withSelfRel();

        List<UserPrivateInfoDTO> UserPrivateInfoDTOList = new ArrayList<>();

        for (UserPrivateInfo entity : UserPrivateInfoList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getUserInfoId()).withSelfRel();
            UserPrivateInfoDTO dto = new UserPrivateInfoDTO(entity, selfLink);
            UserPrivateInfoDTOList.add(dto);

        }

        return new ResponseEntity<>(UserPrivateInfoDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{user_private_info_id}")
    public ResponseEntity<UserPrivateInfoDTO> getUserPrivateInfo(@PathVariable Integer user_private_info_id) throws Exception {
        UserPrivateInfo UserPrivateInfo = service.getUserPrivateInfo(user_private_info_id);
        Link link = linkTo(methodOn(UserPrivateInfoController.class).getUserPrivateInfo(user_private_info_id)).withSelfRel();

        UserPrivateInfoDTO UserPrivateInfoDTO = new UserPrivateInfoDTO(UserPrivateInfo, link);

        return new ResponseEntity<>(UserPrivateInfoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserPrivateInfoDTO> addUserPrivateInfo(@RequestBody UserPrivateInfo UserPrivateInfo) throws Exception {
        service.createUserPrivateInfo(UserPrivateInfo);
        Link link = linkTo(methodOn(UserPrivateInfoController.class).getUserPrivateInfo(UserPrivateInfo.getUserInfoId())).withSelfRel();

        UserPrivateInfoDTO UserPrivateInfoDTO = new UserPrivateInfoDTO(UserPrivateInfo, link);

        return new ResponseEntity<>(UserPrivateInfoDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{user_private_info_id}")
    public ResponseEntity<UserPrivateInfoDTO> updateUserPrivateInfo(@RequestBody UserPrivateInfo uUserPrivateInfo, @PathVariable Integer user_private_info_id) throws Exception {
        service.updateUserPrivateInfo(uUserPrivateInfo, user_private_info_id);
        UserPrivateInfo UserPrivateInfo = service.getUserPrivateInfo(user_private_info_id);
        Link link = linkTo(methodOn(UserPrivateInfoController.class).getUserPrivateInfo(user_private_info_id)).withSelfRel();

        UserPrivateInfoDTO UserPrivateInfoDTO = new UserPrivateInfoDTO(UserPrivateInfo, link);

        return new ResponseEntity<>(UserPrivateInfoDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{user_private_info_id}")
    public ResponseEntity deleteUserPrivateInfo(@PathVariable Integer user_private_info_id) throws Exception {
        service.deleteUserPrivateInfo(user_private_info_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
