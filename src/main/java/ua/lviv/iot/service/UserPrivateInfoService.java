package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.UserPrivateInfo;
import ua.lviv.iot.repository.UserPrivateInfoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserPrivateInfoService {

    @Autowired
    UserPrivateInfoRepository repository;

    public List<UserPrivateInfo> getAllUserPrivateInfo() {
        return repository.findAll();
    }

    public UserPrivateInfo getUserPrivateInfo(Integer id) throws Exception {
        UserPrivateInfo UserPrivateInfo = repository.findById(id).get();
        if (UserPrivateInfo == null) throw new Exception();
        return UserPrivateInfo;
    }

    @Transactional
    public void createUserPrivateInfo(UserPrivateInfo UserPrivateInfo) {
        repository.save(UserPrivateInfo);
    }

    @Transactional
    public void updateUserPrivateInfo(UserPrivateInfo uUserPrivateInfo, Integer id) throws Exception {
        UserPrivateInfo UserPrivateInfo = repository.findById(id).get();
        if (UserPrivateInfo == null) throw new Exception();
        UserPrivateInfo.setLogin(uUserPrivateInfo.getLogin());
        UserPrivateInfo.setPassword(uUserPrivateInfo.getPassword());
        repository.save(UserPrivateInfo);
    }

    @Transactional
    public void deleteUserPrivateInfo(Integer id) throws Exception {
        UserPrivateInfo UserPrivateInfo = repository.findById(id).get();
        if (UserPrivateInfo == null) throw new Exception();
        repository.delete(UserPrivateInfo);
    }
}
