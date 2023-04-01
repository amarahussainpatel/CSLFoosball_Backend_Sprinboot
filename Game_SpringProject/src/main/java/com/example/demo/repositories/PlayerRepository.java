package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

//////////////////////////////////////////////////////////////////////////////////////////////////
//								CUSTOM QUERIES REPOSITORY METHODS
//////////////////////////////////////////////////////////////////////////////////////////////////

//	List<Player> findByFirstName(String firstName);
//	List<Player> findByLastName(String lastName);
//	List<Player> findByCnic(Integer cnic);
//	List<Player> findByStatus(PlayerStatus status);
//	List<Player> findByTeam(Team team);
//	List<Player> findByStatusAndTeam_Name(PlayerStatus status, String teamName);
}
