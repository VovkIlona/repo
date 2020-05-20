package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.ContactPersonInfo;
import ua.lviv.iot.repository.ContactPersonInfoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactPersonInfoService {

    @Autowired
    ContactPersonInfoRepository contactPersonInfoRepository;

    public List<ContactPersonInfo> getAllContactPersonInfo() {
        return contactPersonInfoRepository.findAll();
    }

    public ContactPersonInfo getContactPersonInfo(Integer contactPersonInfo_id) throws Exception {
        ContactPersonInfo contactPersonInfo = contactPersonInfoRepository.findById(contactPersonInfo_id).get();
        if (contactPersonInfo == null) throw new Exception();
        return contactPersonInfo;
    }

    @Transactional
    public void createContactPersonInfo(ContactPersonInfo contactPersonInfo) {
        contactPersonInfoRepository.save(contactPersonInfo);
    }

    @Transactional
    public void updateContactPersonInfo(ContactPersonInfo uContactPersonInfo, Integer contactPersonInfo_id) throws Exception {
        ContactPersonInfo contactPersonInfo = contactPersonInfoRepository.findById(contactPersonInfo_id).get();
        if (contactPersonInfo == null) throw new Exception();
        contactPersonInfo.setName(uContactPersonInfo.getName());
        contactPersonInfo.setSurname(uContactPersonInfo.getSurname());
        contactPersonInfo.setAge(uContactPersonInfo.getAge());
        contactPersonInfo.setPhoneNumber(uContactPersonInfo.getPhoneNumber());
        contactPersonInfo.setEmail(uContactPersonInfo.getEmail());
        contactPersonInfoRepository.save(contactPersonInfo);
    }

    @Transactional
    public void deleteContactPersonInfo(Integer contactPersonInfo_id) throws Exception {
        ContactPersonInfo contactPersonInfo = contactPersonInfoRepository.findById(contactPersonInfo_id).get();
        if (contactPersonInfo == null) throw new Exception();
        contactPersonInfoRepository.delete(contactPersonInfo);
    }
}
