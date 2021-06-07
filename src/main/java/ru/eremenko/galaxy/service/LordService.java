package ru.eremenko.galaxy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eremenko.galaxy.model.Lord;
import ru.eremenko.galaxy.repo.LordRepo;

@Service
public class LordService {
    private final LordRepo lordRepo;

    @Autowired
    public LordService(LordRepo lordRepo) {
        this.lordRepo = lordRepo;
    }

    public List<Lord> findAll() {
        return lordRepo.findAll();
    }

    public Lord saveLord(Lord lord) {
        return lordRepo.save(lord);
    }

    public List<Lord> findUnemployedLords() {
        return lordRepo.findUnemployedLords();
    }
}
