package com.enb.service;

import com.enb.dto.MovieDto;

public interface MovieService {
	MovieDto createMovie(MovieDto moviedto);
    MovieDto getMovieById(Long id);
}
