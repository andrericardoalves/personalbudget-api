package com.alves.personalbudget.service;

import com.alves.personalbudget.model.State;
import com.alves.personalbudget.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public List<State> findAll() {

        return repository.findAll();
    }
}
