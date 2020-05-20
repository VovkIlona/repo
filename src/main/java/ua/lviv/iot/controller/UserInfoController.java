package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.UserInfoDTO;
import ua.lviv.iot.domain.UserInfo;
import ua.lviv.iot.service.UserInfoService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/user_info")
public class UserInfoController {

    @Autowired
    UserInfoService service;

    @GetMapping
    public ResponseEntity<List<UserInfoDTO>> getAllUserInfo() throws Exception {
        List<UserInfo> UserInfoList = service.getAllUserInfo();
        Link link = linkTo(methodOn(UserInfoController.class).getAllUserInfo()).withSelfRel();

        List<UserInfoDTO> UserInfoDTOList = new ArrayList<>();

        for (UserInfo entity : UserInfoList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            UserInfoDTO dto = new UserInfoDTO(entity, selfLink);
            UserInfoDTOList.add(dto);

        }

        return new ResponseEntity<>(UserInfoDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{user_info_id}")
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable Integer user_info_id) throws Exception {
        UserInfo UserInfo = service.getUserInfo(user_info_id);
        Link link = linkTo(methodOn(UserInfoController.class).getUserInfo(user_info_id)).withSelfRel();

        UserInfoDTO UserInfoDTO = new UserInfoDTO(UserInfo, link);

        return new ResponseEntity<>(UserInfoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserInfoDTO> addUserInfo(@RequestBody UserInfo UserInfo) throws Exception {
        service.createUserInfo(UserInfo);
        Link link = linkTo(methodOn(UserInfoController.class).getUserInfo(UserInfo.getId())).withSelfRel();

        UserInfoDTO UserInfoDTO = new UserInfoDTO(UserInfo, link);

        return new ResponseEntity<>(UserInfoDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{user_info_id}")
    public ResponseEntity<UserInfoDTO> updateUserInfo(@RequestBody UserInfo uUserInfo, @PathVariable Integer user_info_id) throws Exception {
        service.updateUserInfo(uUserInfo, user_info_id);
        UserInfo UserInfo = service.getUserInfo(user_info_id);
        Link link = linkTo(methodOn(UserInfoController.class).getUserInfo(user_info_id)).withSelfRel();

        UserInfoDTO UserInfoDTO = new UserInfoDTO(UserInfo, link);

        return new ResponseEntity<>(UserInfoDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{user_info_id}")
    public ResponseEntity deleteUserInfo(@PathVariable Integer user_info_id) throws Exception {
        service.deleteUserInfo(user_info_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
