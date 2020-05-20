package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.LevelOfExperience;
import ua.lviv.iot.repository.LevelOfExperienceRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LevelOfExperienceService {

    @Autowired
    LevelOfExperienceRepository repository;

    public List<LevelOfExperience> getAllLevelOfExperience() {
        return repository.findAll();
    }

    public LevelOfExperience getLevelOfExperience(Integer id) throws Exception {
        LevelOfExperience LevelOfExperience = repository.findById(id).get();
        if (LevelOfExperience == null) throw new Exception();
        return LevelOfExperience;
    }

    @Transactional
    public void createLevelOfExperience(LevelOfExperience LevelOfExperience) {
        repository.save(LevelOfExperience);
    }

    @Transactional
    public void updateLevelOfExperience(LevelOfExperience uLevelOfExperience, Integer id) throws Exception {
        LevelOfExperience LevelOfExperience = repository.findById(id).get();
        if (LevelOfExperience == null) throw new Exception();
        LevelOfExperience.setLevel(uLevelOfExperience.getLevel());
        repository.save(LevelOfExperience);
    }

    @Transactional
    public void deleteLevelOfExperience(Integer id) throws Exception {
        LevelOfExperience LevelOfExperience = repository.findById(id).get();
        if (LevelOfExperience == null) throw new Exception();
        repository.delete(LevelOfExperience);
    }
}
