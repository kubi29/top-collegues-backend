package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Collegue;
import com.example.repository.CollegueRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/collegues")
public class CollegueController {
	
@Autowired CollegueRepository collegueRepository;

	

	@PostConstruct
	public void insertCollegue() {
		collegueRepository.save(new Collegue("jeux", "https://www.obilisk.co/wp-content/uploads/2017/09/femshep-ME.jpg",0));
		collegueRepository.save(new Collegue("manga", "https://i.pinimg.com/736x/87/68/ef/8768ef74668f66d1580e7a4ce4ef97db--b%C4%83ie%C8%9Bi-anime-yandere-anime-boy.jpg",0));

	}

	@GetMapping
	public List<Collegue> listerCollegues(){
		return this.collegueRepository.findAll();
	}

	@GetMapping(value="/{nom}")
	public Collegue getCollegue(@PathVariable String nom) {
		return this.collegueRepository.findByNom(nom);

	}
	
	@PostMapping
	public Collegue setCollegue(@RequestBody Collegue collegue) {
		return this.collegueRepository.save(collegue);

	}


	@PutMapping(value="/{nom}/score")
	public Collegue setCollegueScore(@PathVariable String nom, @RequestBody Collegue collegue) {
		return this.collegueRepository.save(collegue);

	}

	

	

}
