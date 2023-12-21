package com.capfi.gflim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capfi.gflim.model.Film;
import com.capfi.gflim.service.FilmService;

@RestController
@RequestMapping("/films")
@CrossOrigin(origins = "http://localhost:4200")
public class FilmController {
	
	@Autowired
	private FilmService filmService;

    @PostMapping
    public void createFilm(@RequestBody Film film) {
    	this.filmService.createFilm(film);
    }
   
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilm() {
    	return ResponseEntity.ok(this.filmService.getAllFilm());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Film>> getByKeyword(@RequestParam String keyword) {
    	return ResponseEntity.ok(this.filmService.searchFilm(keyword));
    }
}