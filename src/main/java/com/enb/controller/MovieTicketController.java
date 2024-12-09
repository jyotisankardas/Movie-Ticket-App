package com.enb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enb.dto.MovieDto;
import com.enb.dto.TicketDto;
import com.enb.entity.TicketEntity;
import com.enb.service.MovieService;
import com.enb.service.TicketService;

@RestController
@RequestMapping("/theatre")
public class MovieTicketController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TicketService ticketService;

	@PostMapping("/movie")
    public ResponseEntity<MovieDto> createNewMovie(@RequestBody MovieDto moviedto) {
        
        return  new ResponseEntity<MovieDto>(movieService.createMovie(moviedto),HttpStatus.CREATED);
    }

    @PostMapping("/movie/ticket/booking")
    public ResponseEntity<TicketDto> bookMovieTicket(@RequestBody TicketDto ticketdto) {
        
        
        return new ResponseEntity<TicketDto>(ticketService.createTicket(ticketdto),HttpStatus.CREATED);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<MovieDto> getMovieDetails(@PathVariable Long movieId) {
        return new ResponseEntity<MovieDto>(movieService.getMovieById(movieId),HttpStatus.OK);
    }

    @GetMapping("/movie/ticket/booking/{ticketId}")
    public ResponseEntity<TicketDto> getMovieTicketDetails(@PathVariable int ticketId) {
        return new ResponseEntity<TicketDto>(ticketService.getTicketById(ticketId),HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}/ticket")
    public ResponseEntity<TicketDto> getAllMovieTickets(@PathVariable Long movieId) {
        return new ResponseEntity<TicketDto>(ticketService.getTicketsByMovieId(movieId),HttpStatus.OK);
    }
}

