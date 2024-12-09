package com.enb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enb.Exception.InvalidMovieIdException;
import com.enb.dao.MovieRepo;
import com.enb.dto.MovieDto;
import com.enb.entity.MovieEntity;
import com.enb.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;
    
   
    private MovieDto mdto;

    @Override
    public MovieDto createMovie(MovieDto moviedto) {
    	MovieEntity movieentity=new MovieEntity(moviedto.getTitle(), moviedto.getDirector(), moviedto.getLanguage(),
    			moviedto.getYear());
    	
    	MovieEntity save = movieRepo.save(movieentity);
    	//MovieEntity save = null;
    	mdto=new MovieDto();
    	if(save!= null) {
    		mdto.setTitle(save.getTitle());
    		mdto.setDirector(save.getDirector());
    		mdto.setId(save.getId());
    		mdto.setLanguage(save.getLanguage());
    		mdto.setYear(save.getYear());
    	}
    	else 
    		throw new InvalidMovieIdException("movie has not created");
        return mdto;
    }

    @Override
    public MovieDto getMovieById(Long id) {
    	MovieEntity movieEntity = movieRepo.findById(id).get();
    	//MovieEntity movieEntity = null;
    	
    	mdto=new MovieDto();
    	if(movieEntity!= null) {
    		mdto.setTitle(movieEntity.getTitle());
    		mdto.setDirector(movieEntity.getDirector());
    		mdto.setId(movieEntity.getId());
    		mdto.setLanguage(movieEntity.getLanguage());
    		mdto.setYear(movieEntity.getYear());
    	}
    	else 
    		throw new InvalidMovieIdException("movie is not found");
        return mdto;
    }
}
