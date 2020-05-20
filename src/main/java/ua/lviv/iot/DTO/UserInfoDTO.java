package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.CandidateLevel;
import ua.lviv.iot.domain.UserInfo;

import javax.persistence.Basic;
import javax.persistence.Column;

public class UserInfoDTO extends ResourceSupport {

    private UserInfo userInfo;

    public UserInfoDTO(UserInfo userInfo, Link selfLink) throws Exception {
        this.userInfo = userInfo;
        add(selfLink);
    }

    public int getUserInfoId() {
        return userInfo.getId();
    }

    public String getUserInfoName() {
        return userInfo.getName();
    }

    public String getUserInfoSurname() {
        return userInfo.getSurname();
    }

    public int getUserInfoAge() {
        return userInfo.getAge();
    }
}
