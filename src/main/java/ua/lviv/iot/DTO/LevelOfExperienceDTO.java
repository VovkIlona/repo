package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.LevelOfExperience;

public class LevelOfExperienceDTO extends ResourceSupport {

    private LevelOfExperience levelOfExperience;

    public LevelOfExperienceDTO(LevelOfExperience levelOfExperience, Link selfLink) throws Exception {
        this.levelOfExperience = levelOfExperience;
        add(selfLink);
    }

    public int getLevelOfExperienceId() {
        return levelOfExperience.getId();
    }

    public String getLevelOfExperienceLevel() {
        return levelOfExperience.getLevel();
    }


}