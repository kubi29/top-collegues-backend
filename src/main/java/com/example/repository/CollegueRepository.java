package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	public Collegue findByNom(String nom);
}
