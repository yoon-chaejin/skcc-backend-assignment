package com.example.skccbackendassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skccbackendassignment.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    
}
