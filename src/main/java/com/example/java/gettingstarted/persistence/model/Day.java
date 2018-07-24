package com.example.java.gettingstarted.persistence.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "days")
public class Day {

  @Id
  private Long day;

  private String climate;

  private Boolean optimalPressionAndTemperature;

  private Boolean intensityPeak;

  private Double perimeter;

  @Transient
  private List<Planet> planets = new ArrayList<>();

  public Long getDay() {
    return day;
  }

  public Day setDay(Long day) {
    this.day = day;
    return this;
  }

  public String getClimate() {
    return climate;
  }

  public Day setClimate(String climate) {
    this.climate = climate;
    return this;
  }

  public Boolean getOptimalPressionAndTemperature() {
    return optimalPressionAndTemperature;
  }

  public Day setOptimalPressionAndTemperature(Boolean optimalPressionAndTemperature) {
    this.optimalPressionAndTemperature = optimalPressionAndTemperature;
    return this;
  }

  public Boolean getIntensityPeak() {
    return intensityPeak;
  }

  public Day setIntensityPeak(Boolean intensityPeak) {
    this.intensityPeak = intensityPeak;
    return this;
  }

  public Double getPerimeter() {
    return perimeter;
  }

  public Day setPerimeter(Double perimeter) {
    this.perimeter = perimeter;
    return this;
  }

  public List<Planet> getPlanets() {
    return planets;
  }

  public Day setPlanets(
      List<Planet> planets) {
    this.planets = planets;
    return this;
  }
}
