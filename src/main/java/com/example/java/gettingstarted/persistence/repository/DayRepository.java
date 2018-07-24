package com.example.java.gettingstarted.persistence.repository;

import com.example.java.gettingstarted.persistence.model.Day;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DayRepository extends JpaRepository<Day, Long> {

  Optional<Day> findByDay(Long day);

  @Query("SELECT max(d.perimeter) FROM Day d WHERE d.day <= :idMax and d.day>=:idMin and d.climate like 'Lluvia'")
  Double findMaxPerimeter(@Param("idMin") Long idMin, @Param("idMax") Long idMax);

  @Query("SELECT d FROM Day d WHERE d.day <= :idMax and d.day>=:idMin and d.perimeter = :perimeter and d.climate like 'Lluvia'")
  List<Day> findByPerimeterAndDay(@Param("perimeter") Double perimeter, @Param("idMin") Long idMin,
      @Param("idMax") Long idMax);

}
