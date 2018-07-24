package com.example.java.gettingstarted.service;

import com.example.java.gettingstarted.persistence.model.Civilization;
import com.example.java.gettingstarted.persistence.model.Day;
import com.example.java.gettingstarted.persistence.model.Planet;
import com.example.java.gettingstarted.persistence.repository.DayRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DayService {

  @Autowired
  private DayRepository dayRepository;

  @Autowired
  private PlanetService planetService;


  public Day getDay(Long dayNumber) {
    Planet ferengies = planetService.findPlanet(Civilization.FERENGIES, dayNumber);
    Planet vulcanos = planetService.findPlanet(Civilization.VULCANOS, dayNumber);
    Planet betasoides = planetService.findPlanet(Civilization.BETASOIDES, dayNumber);

    Day day = dayRepository.findByDay(dayNumber % 360).orElseThrow(() ->
        new ResourceNotFoundException("Day not found: " + dayNumber));
    day.setPlanets(Lists.newArrayList(ferengies, vulcanos, betasoides)).setDay(dayNumber);
    return day;
  }

  public Day createDay(Long dayNbr) {
    Day day = new Day().setClimate("Normal").setIntensityPeak(false)
        .setOptimalPressionAndTemperature(false)
        .setPerimeter(planetService.perimeterSize(dayNbr))
        .setDay(dayNbr);
    if (planetService.sunAndPlanetsAligned(dayNbr)) {
      day.setClimate("Sequia");
    } else {
      if (planetService.arePlanetsAligned(dayNbr)) {
        day.setOptimalPressionAndTemperature(true);
      } else {
        if (planetService.isSunInTheMiddle(dayNbr)) {
          day.setClimate("Lluvia");
        }
      }
    }
    return day;
  }

  public void saveDay(Day day) {
    dayRepository.save(day);
  }

}
