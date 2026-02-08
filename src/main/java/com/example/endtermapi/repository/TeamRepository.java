package com.example.endtermapi.repository;

import com.example.endtermapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team, Long> {
}