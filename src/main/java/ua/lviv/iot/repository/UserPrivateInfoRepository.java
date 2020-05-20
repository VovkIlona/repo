package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.UserPrivateInfo;

@Repository
public interface UserPrivateInfoRepository extends JpaRepository<UserPrivateInfo, Integer> {
}
