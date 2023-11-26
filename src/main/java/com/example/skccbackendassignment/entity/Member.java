package com.example.skccbackendassignment.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.example.skccbackendassignment.dto.MemberRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String joinedDate;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    @JsonIgnore
    private Team team;

    private Member(String firstName, String lastName, String address, String joinedDate, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.joinedDate = joinedDate;
        this.team = team;
    }

    public static Member of(MemberRequest memberRequest) {
        return new Member(
                memberRequest.getFirstName(),
                memberRequest.getLastName(),
                memberRequest.getAddress(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                memberRequest.getTeam());
    }
}