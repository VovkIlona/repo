package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.UserInfo;
import ua.lviv.iot.repository.UserInfoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository repository;

    public List<UserInfo> getAllUserInfo() {
        return repository.findAll();
    }

    public UserInfo getUserInfo(Integer id) throws Exception {
        UserInfo UserInfo = repository.findById(id).get();
        if (UserInfo == null) throw new Exception();
        return UserInfo;
    }

    @Transactional
    public void createUserInfo(UserInfo UserInfo) {
        repository.save(UserInfo);
    }

    @Transactional
    public void updateUserInfo(UserInfo uUserInfo, Integer id) throws Exception {
        UserInfo UserInfo = repository.findById(id).get();
        if (UserInfo == null) throw new Exception();
        UserInfo.setAge(uUserInfo.getAge());
        UserInfo.setName(uUserInfo.getName());
        UserInfo.setSurname(uUserInfo.getSurname());
        UserInfo.setTechnicalLevelByTechnicalLevelId(uUserInfo.getTechnicalLevelByTechnicalLevelId());
        UserInfo.setLevelOfExperienceByLevelOfExperienceId(uUserInfo.getLevelOfExperienceByLevelOfExperienceId());
        repository.save(UserInfo);
    }

    @Transactional
    public void deleteUserInfo(Integer id) throws Exception {
        UserInfo UserInfo = repository.findById(id).get();
        if (UserInfo == null) throw new Exception();
        repository.delete(UserInfo);
    }
}
