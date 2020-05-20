package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.ItCompanyInfo;

@Repository
public interface ItCompanyInfoRepository extends JpaRepository<ItCompanyInfo, Integer> {
}
