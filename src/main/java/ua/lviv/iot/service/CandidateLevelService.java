package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.CandidateLevel;
import ua.lviv.iot.repository.CandidateLevelRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandidateLevelService {

    @Autowired
    CandidateLevelRepository candidateLevelRepository;

    public List<CandidateLevel> getAllCandidateLevel() {
        return candidateLevelRepository.findAll();
    }

    public CandidateLevel getCandidateLevel(Integer candidateLevel_id) throws Exception {
        CandidateLevel candidateLevel = candidateLevelRepository.findById(candidateLevel_id).get();
        if (candidateLevel == null) throw new Exception();
        return candidateLevel;
    }

    @Transactional
    public void createCandidateLevel(CandidateLevel candidateLevel) {
        candidateLevelRepository.save(candidateLevel);
    }

    @Transactional
    public void updateCandidateLevel(CandidateLevel uCandidateLevel, Integer candidateLevel_id) throws Exception {
        CandidateLevel candidateLevel = candidateLevelRepository.findById(candidateLevel_id).get();
        if (candidateLevel == null) throw new Exception();
        candidateLevel.setLevel(uCandidateLevel.getLevel());
        candidateLevelRepository.save(candidateLevel);
    }

    @Transactional
    public void deleteCandidateLevel(Integer candidateLevel_id) throws Exception {
        CandidateLevel candidateLevel = candidateLevelRepository.findById(candidateLevel_id).get();
        if (candidateLevel == null) throw new Exception();
        candidateLevelRepository.delete(candidateLevel);
    }

}
