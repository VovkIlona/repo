package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.UserPrivateInfo;

public class UserPrivateInfoDTO extends ResourceSupport {

    private UserPrivateInfo userPrivateInfo;

    public UserPrivateInfoDTO(UserPrivateInfo userPrivateInfo, Link selfLink) throws Exception {
        this.userPrivateInfo = userPrivateInfo;
        add(selfLink);
    }

    public int getUserInfoId() {
        return userPrivateInfo.getUserInfoId();
    }

    public String getLogin() {
        return userPrivateInfo.getLogin();
    }

    public String getPassword() {
        return userPrivateInfo.getPassword();
    }

}
