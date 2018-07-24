package com.example.java.gettingstarted.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "planets")
public class Planet {

  @Id
  @Enumerated(EnumType.STRING)
  private Civilization civilization;

  private BigDecimal velocity;

  private BigDecimal sunDistance;

  private BigDecimal initialPosition;

  @Transient
  private Double x;

  @Transient
  private Double y;

  @Transient
  private BigDecimal degrees;

  public Civilization getCivilization() {
    return civilization;
  }

  public Planet setCivilization(
      Civilization civilization) {
    this.civilization = civilization;
    return this;
  }

  public BigDecimal getVelocity() {
    return velocity;
  }

  public Planet setVelocity(BigDecimal velocity) {
    this.velocity = velocity;
    return this;
  }

  public BigDecimal getSunDistance() {
    return sunDistance;
  }

  public Planet setSunDistance(BigDecimal sunDistance) {
    this.sunDistance = sunDistance;
    return this;
  }

  public BigDecimal getInitialPosition() {
    return initialPosition;
  }

  public Planet setInitialPosition(BigDecimal initialPosition) {
    this.initialPosition = initialPosition;
    return this;
  }

  public Double getX() {
    return x;
  }

  public Planet setX(Double x) {
    this.x = x;
    return this;
  }

  public Double getY() {
    return y;
  }

  public Planet setY(Double y) {
    this.y = y;
    return this;
  }

  public BigDecimal getDegrees() {
    return degrees;
  }

  public Planet setDegrees(BigDecimal degrees) {
    this.degrees = degrees;
    return this;
  }
}
