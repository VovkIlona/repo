package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.CandidateLevel;
import ua.lviv.iot.domain.VacancyInfo;

import javax.persistence.Basic;
import javax.persistence.Column;

public class VacancyInfoDTO extends ResourceSupport {

    private VacancyInfo vacancyInfo;

    public VacancyInfoDTO(VacancyInfo vacancyInfo, Link selfLink) throws Exception {
        this.vacancyInfo = vacancyInfo;
        add(selfLink);
    }

    public int getVacancyInfoId() {
        return vacancyInfo.getId();
    }

     public String getVacancyInfoDescription() {
        return vacancyInfo.getDescription();
    }

   public String getVacancyInfoProjectName() {
        return vacancyInfo.getProjectName();
    }

}
