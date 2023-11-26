package com.example.skccbackendassignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.skccbackendassignment.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where CONCAT(firstName, lastName) like %:name%")
    public Page<Member> findAllByNameContaining(@Param("name") String name, Pageable pageable);
}
