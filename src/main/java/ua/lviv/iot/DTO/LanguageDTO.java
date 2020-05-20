package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.CandidateLevel;
import ua.lviv.iot.domain.Language;

import javax.persistence.Basic;
import javax.persistence.Column;

public class LanguageDTO extends ResourceSupport {

    private Language language;

    public LanguageDTO(Language language, Link selfLink) throws Exception {
        this.language = language;
        add(selfLink);

    }

    public int getLanguageId() {
        return language.getId();
    }

    public String getLanguageLanguage() {
        return language.getLanguage();
    }

}
