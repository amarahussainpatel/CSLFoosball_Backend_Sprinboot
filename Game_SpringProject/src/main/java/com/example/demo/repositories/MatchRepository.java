package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Match;
import com.example.demo.models.Team;


@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{
	Team findByName(String name);
}
