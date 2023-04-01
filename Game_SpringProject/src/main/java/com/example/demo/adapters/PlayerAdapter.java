package com.example.demo.adapters;

import com.example.demo.models.Player;
import com.example.demo.models.PlayerSkillCard;
import com.example.demo.models.Team;
import com.example.demo.modelsDTO.PlayerDto;
import com.example.demo.modelsDTO.PlayerSkillCardDto;
import com.example.demo.modelsDTO.TeamDto;

public class PlayerAdapter {
	
	PlayerSkillCardAdapter skillAdapter = new PlayerSkillCardAdapter();
	TeamAdapter teamAdapter = new TeamAdapter();
	
	public Player _toDao(PlayerDto playerDto) {
		
		Player player = new Player();
		return _toDaoUpdate(player, playerDto);
	}
	
	public Player _toDaoUpdate (Player player, PlayerDto playerDto) {
		player.setFirstName(playerDto.getFirstName());
		player.setLastName(playerDto.getLastName());
		player.setCnic(playerDto.getCnic());
		player.setStatus(playerDto.getStatus());
		PlayerSkillCard skills = skillAdapter._toDao(playerDto.getPlayerSkills());
		player.setPlayerSkills(skills);
		skills.setPlayer(player);
		if(null!=playerDto.getTeam()) {
			//player.setTeam();
		}
		//map team here with check playerdto.getteam should not benull
		return player;
	}
	
	
	public PlayerDto _toDto(Player player) {
		PlayerDto playerDto = new PlayerDto();
		playerDto.setId(player.getId());
		playerDto.setFirstName(player.getFirstName());
		playerDto.setLastName(player.getLastName());
		playerDto.setCnic(player.getCnic());
		playerDto.setStatus(player.getStatus());
		TeamDto teamdto = null;
		if(null != player.getTeam()) {
			teamdto = teamAdapter._toDto(player.getTeam());
		}
		playerDto.setTeam(teamdto);
		PlayerSkillCardDto skills = null;
		if(null != player.getPlayerSkills()) {
			skills = skillAdapter._toDto(player.getPlayerSkills());
		}
		playerDto.setPlayerSkills(skills);
		if(null != player.getTeam()) {
			
		}
		return playerDto;
	}
	
	public Player _toDao_withTeam_Update(Player player, PlayerDto playerDto,Team team) {
		player.setId(playerDto.getId());
		player.setFirstName(playerDto.getFirstName());
		player.setLastName(playerDto.getLastName());
		player.setCnic(playerDto.getCnic());
		player.setStatus(playerDto.getStatus());
		PlayerSkillCard skills = skillAdapter._toDao(playerDto.getPlayerSkills());
		player.setPlayerSkills(skills);
		skills.setPlayer(player);
		player.setTeam(team);
		return player;
	}
}
