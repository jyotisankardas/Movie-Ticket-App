package com.enb.service;

import com.enb.dto.TicketDto;
import com.enb.entity.TicketEntity;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketdto);
    
    
    
    TicketDto getTicketById(int id);
  TicketDto getTicketsByMovieId(Long movieId);
}
