package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
