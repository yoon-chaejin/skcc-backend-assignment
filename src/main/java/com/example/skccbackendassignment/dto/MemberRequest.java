package com.example.skccbackendassignment.dto;

import lombok.Data;

@Data
public class MemberRequest {
    private String firstName;
    private String lastName;
    private String address;
    private Long teamId;
}