package ua.lviv.iot.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_info", schema = "Spodaryk_db", catalog = "")
public class UserInfo {
    private int id;
    private String name;
    private String surname;
    private int age;
    private TechnicalLevel technicalLevelByTechnicalLevelId;
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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        if (age != userInfo.age) return false;
        if (name != null ? !name.equals(userInfo.name) : userInfo.name != null) return false;
        if (surname != null ? !surname.equals(userInfo.surname) : userInfo.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "technical_level_id", referencedColumnName = "id", nullable = false)
    public TechnicalLevel getTechnicalLevelByTechnicalLevelId() {
        return technicalLevelByTechnicalLevelId;
    }

    public void setTechnicalLevelByTechnicalLevelId(TechnicalLevel technicalLevelByTechnicalLevelId) {
        this.technicalLevelByTechnicalLevelId = technicalLevelByTechnicalLevelId;
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
