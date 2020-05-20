package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.ContactPersonInfo;

@Repository
public interface ContactPersonInfoRepository  extends JpaRepository<ContactPersonInfo, Integer> {
}
