package com.example.demo.adapters;

import com.example.demo.models.PlayerSkillCard;
import com.example.demo.modelsDTO.PlayerSkillCardDto;

public class PlayerSkillCardAdapter {

	public PlayerSkillCard _toDao (PlayerSkillCardDto skillDto) {
		
		PlayerSkillCard skill = new PlayerSkillCard();
		
		return _toDaoUpdate(skill, skillDto);
	}
	
	public PlayerSkillCard _toDaoUpdate (PlayerSkillCard skill, PlayerSkillCardDto skillDto) {
		if(null!=skillDto.getId()) {
			skill.setId(skillDto.getId());
		}
		skill.setStyle(skillDto.getStyle());
		skill.setTotalPlayedMatches(skillDto.getTotalPlayedMatches());
		skill.setTotalWins(skillDto.getTotalWins());
		skill.setWinPercentage(skillDto.getWinPercentage());
		skill.setWinStreak(skillDto.getWinStreak());
		
		return skill;
	}
	
	public PlayerSkillCardDto _toDto(PlayerSkillCard skill) {
		PlayerSkillCardDto skillDto = new PlayerSkillCardDto();
		
		skillDto.setId(skill.getId());
		skillDto.setStyle(skill.getStyle());
		skillDto.setTotalPlayedMatches(skill.getTotalPlayedMatches());
		skillDto.setTotalWins(skill.getTotalWins());
		skillDto.setWinStreak(skill.getWinStreak());
		
		return skillDto;
	}
	
	
}
