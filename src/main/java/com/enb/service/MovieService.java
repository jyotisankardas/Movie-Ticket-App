package com.enb.service;

import com.enb.dto.MovieDto;
import com.enb.entity.MovieEntity;

public interface MovieService {
	MovieDto createMovie(MovieEntity movieentity);
    MovieDto getMovieById(Long id);
}
