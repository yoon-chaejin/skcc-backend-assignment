package com.example.skccbackendassignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.skccbackendassignment.entity.Team;


@SpringBootTest
public class TeamServiceTest {
    
    @Autowired
    private TeamService teamService;

    @Test
    void testRegister() {
        // given
        Team team = new Team(null, "팀1", "장소", null, null);

        // when
        Object object = teamService.register(team);

        // then
        assertInstanceOf(Team.class, object);
    }

    @Test
    void testFindMemberById() {
        // given
        Team teamBeforeRegister = new Team(null, "팀1", "장소", null, null);
        Team teamAfterRegister = teamService.register(teamBeforeRegister);

        // when
        Team team = teamService.findTeamById(teamAfterRegister.getId());

        // then
        assertEquals(teamBeforeRegister.getName(), team.getName());
        assertEquals(teamBeforeRegister.getLocation(), team.getLocation());
    }
}
