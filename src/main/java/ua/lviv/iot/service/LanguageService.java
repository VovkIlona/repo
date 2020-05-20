package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Language;
import ua.lviv.iot.repository.LanguageRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository repository;

    public List<Language> getAllLanguage() {
        return repository.findAll();
    }

    public Language getLanguage(Integer id) throws Exception {
        Language Language = repository.findById(id).get();
        if (Language == null) throw new Exception();
        return Language;
    }

    @Transactional
    public void createLanguage(Language language) {
        repository.save(language);
    }

    @Transactional
    public void updateLanguage(Language uLanguage, Integer id) throws Exception {
        Language language = repository.findById(id).get();
        if (language == null) throw new Exception();
        language.setLanguage(uLanguage.getLanguage());
        repository.save(language);
    }

    @Transactional
    public void deleteLanguage(Integer id) throws Exception {
        Language Language = repository.findById(id).get();
        if (Language == null) throw new Exception();
        repository.delete(Language);
    }
}
