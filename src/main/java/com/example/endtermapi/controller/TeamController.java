package com.example.endtermapi.controller;

import com.example.endtermapi.model.Team;
import com.example.endtermapi.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return teamService.create(team);
    }
    @GetMapping
    public List<Team> getAll() {
        return teamService.getAll();
    }


    @GetMapping("/{id}")
    public Team getById(@PathVariable Long id) {
        return teamService.getById(id);
    }
}
