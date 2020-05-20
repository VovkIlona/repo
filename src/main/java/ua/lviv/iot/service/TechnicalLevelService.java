package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.TechnicalLevel;
import ua.lviv.iot.repository.TechnicalLevelRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TechnicalLevelService {

    @Autowired
    TechnicalLevelRepository repository;

    public List<TechnicalLevel> getAllTechnicalLevel() {
        return repository.findAll();
    }

    public TechnicalLevel getTechnicalLevel(Integer id) throws Exception {
        TechnicalLevel TechnicalLevel = repository.findById(id).get();
        if (TechnicalLevel == null) throw new Exception();
        return TechnicalLevel;
    }

    @Transactional
    public void createTechnicalLevel(TechnicalLevel TechnicalLevel) {
        repository.save(TechnicalLevel);
    }

    @Transactional
    public void updateTechnicalLevel(TechnicalLevel uTechnicalLevel, Integer id) throws Exception {
        TechnicalLevel TechnicalLevel = repository.findById(id).get();
        if (TechnicalLevel == null) throw new Exception();
        TechnicalLevel.setLevel(uTechnicalLevel.getLevel());
        repository.save(TechnicalLevel);
    }

    @Transactional
    public void deleteTechnicalLevel(Integer id) throws Exception {
        TechnicalLevel TechnicalLevel = repository.findById(id).get();
        if (TechnicalLevel == null) throw new Exception();
        repository.delete(TechnicalLevel);
    }
}
