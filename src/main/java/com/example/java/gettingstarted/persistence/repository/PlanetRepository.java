package com.example.java.gettingstarted.persistence.repository;

import com.example.java.gettingstarted.persistence.model.Civilization;
import com.example.java.gettingstarted.persistence.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

  Planet findByCivilization(Civilization ferengies);

}
