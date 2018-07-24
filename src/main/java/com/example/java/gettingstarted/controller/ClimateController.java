package com.example.java.gettingstarted.controller;

import static com.google.common.base.Preconditions.checkArgument;

import com.example.java.gettingstarted.persistence.model.Day;
import com.example.java.gettingstarted.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/clima")
public class ClimateController {

  @Autowired
  private DayService dayService;


  @GetMapping
  public Day getDay(@RequestParam Long day) {
    checkArgument(day >= 0, "Day number must be ge 0");
    Day dayO = dayService.getDay(day);
    return dayO;
  }

}
