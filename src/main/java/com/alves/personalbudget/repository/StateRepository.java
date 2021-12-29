package com.alves.personalbudget.repository;

import com.alves.personalbudget.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository  extends JpaRepository<State, Long> {
}
