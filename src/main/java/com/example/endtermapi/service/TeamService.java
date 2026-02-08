package com.example.endtermapi.service;

import com.example.endtermapi.model.Team;

import java.util.List;

public interface TeamService {

    Team create(Team team);

    List<Team> getAll();

    Team getById(Long id);
}
