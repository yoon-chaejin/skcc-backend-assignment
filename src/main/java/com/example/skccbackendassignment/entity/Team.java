package com.example.skccbackendassignment.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.example.skccbackendassignment.dto.TeamRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String location;

    @NotNull
    private String foundedDate;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    private Team(String name, String location, String foundedDate) {
        this.name = name;
        this.location = location;
        this.foundedDate = foundedDate;
    }

    public static Team of(TeamRequest teamRequest) {
        return new Team(
                teamRequest.getName(),
                teamRequest.getLocation(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        );
    }
}