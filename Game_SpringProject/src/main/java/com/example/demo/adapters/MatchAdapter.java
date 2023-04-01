package com.example.demo.adapters;

import com.example.demo.models.*;
import com.example.demo.modelsDTO.*;


public class MatchAdapter {
	
	TeamAdapter teamAdapter = new TeamAdapter();
	
	
	public MatchGetDto _toDto(Match match) {
		MatchGetDto matchDto = new MatchGetDto();
		matchDto.setId(match.getId());
		matchDto.setName(match.getName());
		matchDto.setTeam_1(match.getTeam_1().getName());
		matchDto.setTeam_2(match.getTeam_2().getName());
		matchDto.setRoundsWinByTeam_1(match.getRoundsWinByTeam_1());
		matchDto.setRoundsWinByTeam_2(match.getRoundsWinByTeam_2());
		matchDto.setToss(match.getToss());
		matchDto.setWinner(match.getWinner());
		matchDto.setLocation(match.getLocation());
		
		return matchDto;
	}
}
