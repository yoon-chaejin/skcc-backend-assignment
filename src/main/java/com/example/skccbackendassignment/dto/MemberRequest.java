package com.example.skccbackendassignment.dto;

import com.example.skccbackendassignment.entity.Team;

import lombok.Data;

@Data
public class MemberRequest {
    private String firstName;
    private String lastName;
    private String address;
    private Team team;
}