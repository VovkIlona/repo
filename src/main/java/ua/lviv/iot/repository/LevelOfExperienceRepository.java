package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.LevelOfExperience;

@Repository
public interface LevelOfExperienceRepository extends JpaRepository<LevelOfExperience, Integer> {
}
