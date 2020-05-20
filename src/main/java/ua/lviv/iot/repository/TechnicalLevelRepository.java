package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.TechnicalLevel;

@Repository
public interface TechnicalLevelRepository extends JpaRepository<TechnicalLevel, Integer> {
}
