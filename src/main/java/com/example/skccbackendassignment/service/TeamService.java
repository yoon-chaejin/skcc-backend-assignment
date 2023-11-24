package com.example.skccbackendassignment.service;

import org.springframework.stereotype.Service;

import com.example.skccbackendassignment.entity.Team;
import com.example.skccbackendassignment.repository.TeamRepository;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team findTeamById(Long id) {
        return teamRepository.findById(id).get();
    }

    public Team register(Team team) {
        return teamRepository.save(team);
    }

}
