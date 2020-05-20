package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.VacancyInfo;
import ua.lviv.iot.repository.VacancyInfoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VacancyInfoService {

    @Autowired
    VacancyInfoRepository repository;

    public List<VacancyInfo> getAllVacancyInfo() {
        return repository.findAll();
    }

    public VacancyInfo getVacancyInfo(Integer id) throws Exception {
        VacancyInfo VacancyInfo = repository.findById(id).get();
        if (VacancyInfo == null) throw new Exception();
        return VacancyInfo;
    }

    @Transactional
    public void createVacancyInfo(VacancyInfo VacancyInfo) {
        repository.save(VacancyInfo);
    }

    @Transactional
    public void updateVacancyInfo(VacancyInfo uVacancyInfo, Integer id) throws Exception {
        VacancyInfo VacancyInfo = repository.findById(id).get();
        if (VacancyInfo == null) throw new Exception();
        VacancyInfo.setDescription(uVacancyInfo.getDescription());
        VacancyInfo.setItCompanyInfoByItCompanyInfoId(uVacancyInfo.getItCompanyInfoByItCompanyInfoId());
        VacancyInfo.setLanguageByLanguageId(uVacancyInfo.getLanguageByLanguageId());
        VacancyInfo.setLevelOfExperienceByLevelOfExperienceId(uVacancyInfo.getLevelOfExperienceByLevelOfExperienceId());
        VacancyInfo.setProjectName(uVacancyInfo.getProjectName());
        repository.save(VacancyInfo);
    }

    @Transactional
    public void deleteVacancyInfo(Integer id) throws Exception {
        VacancyInfo VacancyInfo = repository.findById(id).get();
        if (VacancyInfo == null) throw new Exception();
        repository.delete(VacancyInfo);
    }
}
