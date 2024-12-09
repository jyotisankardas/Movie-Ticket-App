package com.enb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enb.Exception.InvalidTicketIdException;
import com.enb.dao.MovieRepo;
import com.enb.dao.TicketRepo;
import com.enb.dto.MovieDto;
import com.enb.dto.TicketDto;
import com.enb.entity.MovieEntity;
import com.enb.entity.TicketEntity;
import com.enb.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;
    
    @Autowired
    private MovieRepo movieRepo;

    private TicketDto tdto;

    @Override
    public TicketDto createTicket(TicketDto ticketdto) {
        
    	ticketdto.setPrice(ticketdto.getUnitPrice() * ticketdto.getNoOfTickets());
    	

    	TicketEntity ticketentity=new TicketEntity(ticketdto.getType(), ticketdto.getTitle(), ticketdto.getUnitPrice(),
   		ticketdto.getNoOfTickets(), ticketdto.getPrice(),movieRepo.findById(ticketdto.getMoviedto().getId()).get());
    	
    	
    	
    	TicketEntity save = ticketRepo.save(ticketentity);
    	//TicketEntity save = null;
    	
    	tdto=new TicketDto();
    	if(save!= null) {
    		tdto.setNoOfTickets(save.getNoOfTickets());
    		tdto.setPrice(save.getPrice());
    		tdto.setTitle(save.getTitle());
    		tdto.setType(save.getType());
    		tdto.setUnitPrice(save.getUnitPrice());
    		tdto.setId(save.getId());
    		tdto.setMoviedto(entityToDto(save.getMovie()));
    	}
    	else 
    		throw new InvalidTicketIdException("Ticket is not created");
    
    	
    	
        return tdto;
    }
    
    public static MovieDto entityToDto(MovieEntity movieEntity) {
    	MovieDto moviedto = new MovieDto();
        
    	moviedto.setDirector(movieEntity.getDirector());
    	moviedto.setTitle(movieEntity.getTitle());
    	moviedto.setLanguage(movieEntity.getLanguage());
    	moviedto.setYear(movieEntity.getYear());
    	moviedto.setId(movieEntity.getId());
    	//moviedto.setTickets(movieEntity.getTickets().stream().collect(Collectors.toList()));    
    	return moviedto;
    }
    

    @Override
    public TicketDto getTicketById(int id) {
         TicketEntity ticketEntity = ticketRepo.findById(id).get();
         //TicketEntity ticketEntity = null;
         
         tdto=new TicketDto();
     	if(ticketEntity!= null) {
     		tdto.setNoOfTickets(ticketEntity.getNoOfTickets());
     		tdto.setPrice(ticketEntity.getPrice());
     		tdto.setTitle(ticketEntity.getTitle());
     		tdto.setType(ticketEntity.getType());
     		tdto.setUnitPrice(ticketEntity.getUnitPrice());
     	}
     	else 
     		throw new InvalidTicketIdException("Ticket is not there");
     
     	
     	
         return tdto;
     }


    @Override
    public TicketDto getTicketsByMovieId(Long movieId) {
    	List<TicketEntity> allByMovieId = ticketRepo.findAllByMovieId(movieId);
    	//List<TicketEntity> allByMovieId =null;
    	
    	 tdto=new TicketDto();
      	if(allByMovieId!= null) {
      		tdto.setNoOfTickets(allByMovieId.get(0).getNoOfTickets());
      		tdto.setPrice(allByMovieId.get(0).getPrice());
      		tdto.setTitle(allByMovieId.get(0).getTitle());
      		tdto.setType(allByMovieId.get(0).getType());
      		tdto.setUnitPrice(allByMovieId.get(0).getUnitPrice());
      	}
      	else 
      		throw new InvalidTicketIdException("Ticket is not found");
      
      	
      	
          return tdto;
      }

}


