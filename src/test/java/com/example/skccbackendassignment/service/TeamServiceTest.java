package com.example.skccbackendassignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
        Team teamBeforeRegister = new Team(null, "팀1", "장소", "20231126", null);
        Team teamAfterRegister = teamService.register(teamBeforeRegister);

        // when
        Team team = teamService.findTeamById(teamAfterRegister.getId());

        // then
        assertEquals(teamBeforeRegister.getName(), team.getName());
        assertEquals(teamBeforeRegister.getLocation(), team.getLocation());
    }

    @Test
    void testFindTeamByPageGiven7TeamsAndPageableOfSize5() {
        // given
        for (int i=0; i<7; i++) {
            Team team = new Team(null, "팀1", "장소", "20231126", null);
            teamService.register(team);
        }

        // when
        Pageable pageableOne = Pageable.ofSize(5);
        Page<Team> resultOne = teamService.findTeamByPage(pageableOne);
        
        Pageable pageableTwo = pageableOne.next();
        Page<Team> resultTwo = teamService.findTeamByPage(pageableTwo);

        Pageable pageableThree = pageableTwo.next();
        Page<Team> resultThree = teamService.findTeamByPage(pageableThree);


        // then
        assertEquals(5, resultOne.getNumberOfElements());
        assertEquals(2, resultTwo.getNumberOfElements());
        assertEquals(0, resultThree.getNumberOfElements());
    }
}
