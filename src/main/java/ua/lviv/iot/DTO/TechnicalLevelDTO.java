package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.CandidateLevel;
import ua.lviv.iot.domain.TechnicalLevel;

public class TechnicalLevelDTO extends ResourceSupport {

    private TechnicalLevel technicalLevel;

    public TechnicalLevelDTO(TechnicalLevel technicalLevel, Link selfLink) throws Exception {
        this.technicalLevel = technicalLevel;
        add(selfLink);
    }

    public int getTechnicalLevelId() {
        return technicalLevel.getId();
    }

    public String getTechnicalLevelLevel() {
        return technicalLevel.getLevel();
    }
}