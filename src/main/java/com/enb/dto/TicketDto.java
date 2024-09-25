package com.enb.dto;

import lombok.Data;

@Data
public class TicketDto {


    private String type;
    
    private String title;

    private double unitPrice;

    private int noOfTickets;

   private double price;
}

