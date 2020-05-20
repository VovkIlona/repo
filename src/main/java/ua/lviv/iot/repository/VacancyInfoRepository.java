package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.VacancyInfo;

@Repository
public interface VacancyInfoRepository extends JpaRepository<VacancyInfo, Integer> {
}
