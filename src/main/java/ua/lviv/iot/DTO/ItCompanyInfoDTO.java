package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.CandidateLevel;
import ua.lviv.iot.domain.ItCompanyInfo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

public class ItCompanyInfoDTO extends ResourceSupport {

    private ItCompanyInfo itCompanyInfo;

    public ItCompanyInfoDTO(ItCompanyInfo itCompanyInfo, Link selfLink) throws Exception {
        this.itCompanyInfo = itCompanyInfo;
        add(selfLink);
    }

    public int getItCompanyInfoId() {
        return itCompanyInfo.getId();
    }

    public String getItCompanyInfoName() {
        return itCompanyInfo.getName();
    }

}
