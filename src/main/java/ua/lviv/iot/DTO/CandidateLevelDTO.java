package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.CandidateLevel;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class CandidateLevelDTO extends ResourceSupport {
    private CandidateLevel candidateLevel;

    public CandidateLevelDTO(CandidateLevel candidateLevel, Link selfLink) {
        this.candidateLevel = candidateLevel;
        add(selfLink);
    }

    public int getCandidateLevelsId() {
        return candidateLevel.getId();
    }


    public String getCandidateLevelsLevel() {
        return candidateLevel.getLevel();
    }
}
