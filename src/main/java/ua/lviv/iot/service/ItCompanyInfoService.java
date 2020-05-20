package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.ItCompanyInfo;
import ua.lviv.iot.repository.ItCompanyInfoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItCompanyInfoService {

    @Autowired
    ItCompanyInfoRepository itCompanyInfoRepository;

    public List<ItCompanyInfo> getAllItCompanyInfo() {
        return itCompanyInfoRepository.findAll();
    }

    public ItCompanyInfo getItCompanyInfo(Integer itCompanyInfoId) throws Exception {
        ItCompanyInfo itCompanyInfo = itCompanyInfoRepository.findById(itCompanyInfoId).get();
        if (itCompanyInfo == null) throw new Exception();
        return itCompanyInfo;
    }

    @Transactional
    public void createItCompanyInfo(ItCompanyInfo itCompanyInfo) {
        itCompanyInfoRepository.save(itCompanyInfo);
    }

    @Transactional
    public void updateItCompanyInfo(ItCompanyInfo uItCompanyInfo, Integer itCompanyInfoId) throws Exception {
        ItCompanyInfo itCompanyInfo = itCompanyInfoRepository.findById(itCompanyInfoId).get();
        if (itCompanyInfo == null) throw new Exception();
        itCompanyInfo.setName(uItCompanyInfo.getName());
        itCompanyInfoRepository.save(itCompanyInfo);
    }

    @Transactional
    public void deleteItCompanyInfo(Integer itCompanyInfoId) throws Exception {
        ItCompanyInfo itCompanyInfo = itCompanyInfoRepository.findById(itCompanyInfoId).get();
        if (itCompanyInfo == null) throw new Exception();
        itCompanyInfoRepository.delete(itCompanyInfo);
    }

}
