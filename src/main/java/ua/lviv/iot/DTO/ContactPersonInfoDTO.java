package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.ContactPersonInfo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

public class ContactPersonInfoDTO extends ResourceSupport {

    private ContactPersonInfo contactPersonInfo;

    public ContactPersonInfoDTO(ContactPersonInfo contactPersonInfo, Link selfLink) throws Exception {
        this.contactPersonInfo = contactPersonInfo;
        add(selfLink);
    }

    public Integer getContactPersonInfoId() {
        return contactPersonInfo.getId();
    }


    public String getContactPersonInfoName() {
        return contactPersonInfo.getName();
    }


    public String getContactPersonInfoSurname() {
        return contactPersonInfo.getSurname();
    }

    public int getContactPersonInfoAge() {
        return contactPersonInfo.getAge();
    }


    public int getContactPersonInfoPhoneNumber() {
        return contactPersonInfo.getPhoneNumber();
    }


    public String getContactPersonInfoEmail() {
        return contactPersonInfo.getEmail();
    }


}
