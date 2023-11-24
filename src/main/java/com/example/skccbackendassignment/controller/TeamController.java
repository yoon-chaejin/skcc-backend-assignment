package com.example.skccbackendassignment.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.skccbackendassignment.dto.TeamRequest;
import com.example.skccbackendassignment.entity.Team;
import com.example.skccbackendassignment.service.TeamService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/team")
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    @GetMapping("/{id}")
    public Team findTeamById(@PathVariable("id") Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping
    public Team registerTeam(@RequestBody TeamRequest teamRequest) {
        Team team = Team.of(teamRequest);
        return teamService.register(team);
    }
}
