package com.enb.dto;

import java.util.List;

import lombok.Data;

@Data
public class MovieDto {

	private Long id;
    private String title;
    private String director;
    private String language;
    private int year;
    private List<TicketDto> tickets;  // List of tickets for this movie

    public MovieDto() {}

    public MovieDto(Long id, String title, String director, String language, int year, List<TicketDto> tickets) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.language = language;
        this.year = year;
        this.tickets = tickets;
    }

  
}
