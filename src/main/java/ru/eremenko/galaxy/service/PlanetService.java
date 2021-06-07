package ru.eremenko.galaxy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eremenko.galaxy.model.Planet;
import ru.eremenko.galaxy.repo.PlanetRepo;

@Service
public class PlanetService {
    private final PlanetRepo planetRepo;

    @Autowired
    public PlanetService(PlanetRepo planetRepo) {
        this.planetRepo = planetRepo;
    }

    public List<Planet> findAll() {
        return planetRepo.findAll();
    }

    public Planet findById(Long id) {
        return planetRepo.getById(id);
    }

    public Planet savePlanet(Planet planet) {
        return planetRepo.save(planet);
    }

    public void deleteById(Long id) {
        planetRepo.deleteById(id);
    }
}
