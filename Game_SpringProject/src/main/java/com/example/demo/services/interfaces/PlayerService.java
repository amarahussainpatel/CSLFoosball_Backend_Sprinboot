package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.modelsDTO.PlayerDto;

public interface PlayerService {
	
//////////////////////////////////////////////////////////////////////////////////////////////////
//							PLAYER SERVICE CRUD ABSTRACT METHODS
//////////////////////////////////////////////////////////////////////////////////////////////////

	public  PlayerDto add(PlayerDto player);
	public List<PlayerDto> getAll();
	public PlayerDto findById(long id);
	public String deleteById(long id);
	public String deleteAll();
	public PlayerDto update(PlayerDto playerDto);
	//public PlayerDto _toDTO_withTeam_Update()
}
