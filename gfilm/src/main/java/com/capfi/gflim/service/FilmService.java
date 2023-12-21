package com.capfi.gflim.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capfi.gflim.model.Film;

import jakarta.annotation.PostConstruct;

@Service
public class FilmService {

	private List<Film> listFilm = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		listFilm.add(new Film("Sea Bathing", "Baignade en mer", 1896));
		listFilm.add(new Film("Le clown et ses chiens", "Le clown et ses chiens", 1895));
		listFilm.add(new Film("Super Mario", "Super Mario", 1876));
		listFilm.add(new Film("Leaving the Factory", "La sortie de l'usine Lumière à Lyon", 1895));
		listFilm.add(new Film("A Merry-Go-Round", "Les chevaux de bois", 1896));
		listFilm.add(new Film("Conjurer Making Ten Hats in Sixty Seconds", "Dix chapeaux en 60 secondes", 1896));
	}
	
	public List<Film> searchFilm(String keyword) {
		return listFilm.stream().filter(e -> 
			e.getOriginalTitle().contains(keyword)|| e.getPrimaryTitle().contains(keyword))
				.collect(Collectors.toList());
	}
	
	public List<Film> sortFilmByStartYear() {
		return listFilm.stream()
				.sorted(Comparator.comparingInt(Film::getStartYear))
				.collect(Collectors.toList());
	}
	
	public List<Film> getAllFilm() {
		return listFilm;
	}
	
	public void createFilm(Film film) {
		listFilm.add(new Film(film.getPrimaryTitle(), film.getOriginalTitle(), film.getStartYear()));
	}
}
