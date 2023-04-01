package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.adapters.PlayerAdapter;
import com.example.demo.adapters.TeamAdapter;
import com.example.demo.models.Team;
import com.example.demo.modelsDTO.PlayerDto;
import com.example.demo.modelsDTO.TeamDto;
import com.example.demo.repositories.PlayerRepository;
import com.example.demo.repositories.TeamRepostiory;
import com.example.demo.services.interfaces.PlayerService;
import com.example.demo.services.interfaces.TeamService;


@Service
@Transactional
public class TeamServiceImpl implements TeamService{

//////////////////////////////////////////////////////////////////////////////////////////////////
//									AUTOWIRED BEANS
//////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	public TeamRepostiory teamRepo;
	
	@Autowired
	public PlayerRepository playerRepo;
	
	@Autowired
	public PlayerService playerService;
	
//////////////////////////////////////////////////////////////////////////////////////////////////
//										ADAPTERS
//////////////////////////////////////////////////////////////////////////////////////////////////

	public TeamAdapter teamAdapter = new TeamAdapter();
	public PlayerAdapter playerAdapter = new PlayerAdapter();
	
//////////////////////////////////////////////////////////////////////////////////////////////////
//							TEAM BASIC CRUD ABSTRACT METHOD'S IMPLEMENTATION
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String add(TeamDto teamDto) {
		
		Team team = teamAdapter._toDao(teamDto);
		teamRepo.save(team);
		return teamAdapter._toDto(team).toString();
	}

	public List<TeamDto> getAll() {
		
		List<Team> teamList = teamRepo.findAll();
		List<TeamDto> teamDtoList = new ArrayList<>();
		
		for (Team team : teamList) {
			teamDtoList.add(teamAdapter._toDto(team));
		}
		
		return teamDtoList;
	}

	public TeamDto findById(long id) {
		
		Optional<Team> team = teamRepo.findById(id);
		if (team.isPresent()) {
			TeamDto teamDto = teamAdapter._toDto(team.get());
			return teamDto;
		}
		
		return null;
	}

	public String update(long id, TeamDto teamDto) {
		Optional<Team> team = teamRepo.findById(id);
		if (team.isPresent()) {
			teamAdapter._toDaoUpdate(team.get(), teamDto);
			return "Team with id: " + id + " updated Successfully!!!" ;
		}
		return "Team with id: " + id + " not Found!!!";
	}
	
	public String delete(long id) {
		Optional<Team> team = teamRepo.findById(id);
		if (team.isPresent()) {
			teamRepo.delete(team.get());
			return "Team with id: " + id + " deleted Successfully!!!" ;
		}
		return "Team with id: " + id + " not Found!!!";
	}

	public String deleteAll() {
		teamRepo.deleteAll();
		return "All teams data deleted Successfully!!!";
	}

	@Override
	public PlayerDto getTeamCaptain(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerDto> getAllCaptain() {
		// TODO Auto-generated method stub
		return null;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////
//						TEAM CAPTAOM ABSTRACT METHOD'S IMPLEMENTATION
//////////////////////////////////////////////////////////////////////////////////////////////////

//	public PlayerDto getTeamCaptain(long teamId) {
//		Optional<Team> team = teamRepo.findById(teamId);
//		if (team.isPresent()) {
//			Player player = (Player) playerRepo.findByStatusAndTeam_Name(PlayerStatus.Captain, team.get().getName());
//			PlayerDto playerDto = playerAdapter._toDto(player);
//			return playerDto;
//		}
//		
//		return null;
//	}
//	
//	public List<PlayerDto> getAllCaptain() {
//		List<Player> playerList  = playerRepo.findByStatus(PlayerStatus.Captain);
//		List<PlayerDto> listDto = new ArrayList<>();
//		
//		for (Player player : playerList) {
//			listDto.add(playerAdapter._toDto(player));
//		}
//		
//		return listDto;
//	}
	
	
	
}
/*	
	@Autowired
    CaptainService captainService;

	CaptainAdapter captainAdapter = new CaptainAdapter();
	
	@Override
	public TeamDto add(TeamDto teamDto) {
		
		Optional<Team> team = teamRepository.findByName("teamA");
		if (team.isPresent()) {
		    Team foundTeam = team.get();
		    // Do something with the found team
		} else {
		    // Handle case where team was not found
		}
		
		Team team = new Team();
		
		team.setName(teamDto.getName());
		
		CaptainDto captainDto = captainService.findByID(teamDto.getCaptain());
		team.setCaptain(captainAdapter._toDao(captainDto));
		
		return dozer.map(team, TeamDto.class);
	}
	


	@Override
	public List<TeamDto> getAll() {
		List<Team> team = new ArrayList<>();
		List<TeamDto> teamDto = new ArrayList<>();
		team = teamRepo.findAll();
		for (Team object : team) {
			teamDto.add(dozer.map(object, TeamDto.class));
		}
		return teamDto;
	}

}
	@Override
public TeamDto add(TeamDto teamDto) {
	Team teamDao = dozer.map(teamDto, Team.class);
	
	
	Team team = new Team();
	
	team.setName(teamDto.getName());
	
	CaptainDto captainDto = teamDto.getCaptain();
	if (captainDto != null) {
		Captain captain = new Captain();
	}
	
	teamRepo.save(teamDao);
	return teamDto;
}
*/