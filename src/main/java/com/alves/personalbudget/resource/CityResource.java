package com.alves.personalbudget.resource;

import com.alves.personalbudget.model.City;
import com.alves.personalbudget.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/city")
public class CityResource {

    @Autowired
    private CityService service;

    @GetMapping(path = "/findStateById")
    public List<City> findStateById(@RequestParam  Long id){

        return service.findStateById(id);
    }

}
