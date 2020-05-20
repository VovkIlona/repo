package ua.lviv.iot.domain;

import javax.persistence.*;

@Entity
@Table(name = "vacancy_info", schema = "Spodaryk_db", catalog = "")
public class VacancyInfo {
    private int id;
    private String description;
    private String projectName;
    private ItCompanyInfo itCompanyInfoByItCompanyInfoId;
    private Language languageByLanguageId;
    private LevelOfExperience levelOfExperienceByLevelOfExperienceId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 225)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "project_name", nullable = false, length = 45)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacancyInfo that = (VacancyInfo) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "it_company_info_id", referencedColumnName = "id", nullable = false)
    public ItCompanyInfo getItCompanyInfoByItCompanyInfoId() {
        return itCompanyInfoByItCompanyInfoId;
    }

    public void setItCompanyInfoByItCompanyInfoId(ItCompanyInfo itCompanyInfoByItCompanyInfoId) {
        this.itCompanyInfoByItCompanyInfoId = itCompanyInfoByItCompanyInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    public Language getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public void setLanguageByLanguageId(Language languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

    @ManyToOne
    @JoinColumn(name = "level_of_experience_id", referencedColumnName = "id", nullable = false)
    public LevelOfExperience getLevelOfExperienceByLevelOfExperienceId() {
        return levelOfExperienceByLevelOfExperienceId;
    }

    public void setLevelOfExperienceByLevelOfExperienceId(LevelOfExperience levelOfExperienceByLevelOfExperienceId) {
        this.levelOfExperienceByLevelOfExperienceId = levelOfExperienceByLevelOfExperienceId;
    }
}
