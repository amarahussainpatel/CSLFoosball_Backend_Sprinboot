package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelsDTO.TeamDto;
import com.example.demo.services.interfaces.TeamService;


@CrossOrigin(value="*")
@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	TeamService teamService;

	@PostMapping("/add")
	public ResponseEntity<Object> addData(@RequestBody TeamDto teamDto) {
		return new ResponseEntity(teamService.add(teamDto), HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<Object> getAllData(){
		return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
	}
	
//	@DeleteMapping("/delete")
//	public ResponseEntity<Object> deleteData(@RequestBody TeamDto teamDto){
//		teamService.delete(teamDto);
//	}
}
