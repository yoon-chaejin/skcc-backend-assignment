package com.example.skccbackendassignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.skccbackendassignment.dto.MemberRequest;

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

    private String firstName;

    private String lastName;

    private String address;

    private String joinedDate;

    @ManyToOne
    private Team team;

    public static Member of(MemberRequest memberRequest) {
        return new Member(
                null,
                memberRequest.getFirstName(),
                memberRequest.getLastName(),
                memberRequest.getAddress(),
                null,
                null);
    }
}