package com.alves.personalbudget.resource;

import com.alves.personalbudget.model.State;
import com.alves.personalbudget.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/state")
public class StateResource {

    @Autowired
    private StateService service;

    @GetMapping(path = "/findAll")
    public List<State> findAll(){

        return service.findAll();
    }
}
