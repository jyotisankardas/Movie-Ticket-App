package com.enb.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "MOVIE_ENTITY")
@Data
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String language;

    @Column(name = "release_year", nullable = false)
    private int year;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<TicketEntity> tickets;

	
    public MovieEntity(String title, String director, String language, int year) {
		super();
		this.title = title;
		this.director = director;
		this.language = language;
		this.year = year;
		
	}

    // Getters and setters
}
