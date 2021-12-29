package com.alves.personalbudget.service;

import com.alves.personalbudget.model.City;
import com.alves.personalbudget.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> findStateById(Long id){

        return repository.findStateById(id);
    }
}
