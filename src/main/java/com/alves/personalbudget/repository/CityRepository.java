package com.alves.personalbudget.repository;

import com.alves.personalbudget.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    public List<City> findStateById(Long id);

}
