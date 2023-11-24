package com.example.skccbackendassignment.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private Long id;

    private String name;

    private String location;

    private String foundedDate;

    @OneToMany(mappedBy="team")
    private List<Member> members;

    public static Team of(TeamRequest teamRequest) {
        return new Team(
                null,
                teamRequest.getName(),
                teamRequest.getLocation(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                null);
    }
}