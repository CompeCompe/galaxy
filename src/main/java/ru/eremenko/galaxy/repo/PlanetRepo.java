package ru.eremenko.galaxy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eremenko.galaxy.model.Planet;

@Repository
public interface PlanetRepo extends JpaRepository<Planet, Long> {
}
