package com.enb.dto;

import lombok.Data;

@Data
public class TicketDto {


    
   
   
   private int id;
   private String type;
   private String title;
   private double unitPrice;
   private int noOfTickets;
   private double price;
   private MovieDto moviedto; 
   
   
   public TicketDto() {}

   public TicketDto(int id, String type, String title, double unitPrice, int noOfTickets, double price, MovieDto moviedto) {
       this.id = id;
       this.type = type;
       this.title = title;
       this.unitPrice = unitPrice;
       this.noOfTickets = noOfTickets;
       this.price = price;
       this.moviedto = moviedto;
   }
}
