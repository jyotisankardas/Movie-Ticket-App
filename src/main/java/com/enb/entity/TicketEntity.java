package com.enb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TICKET_ENTITY")
@Data
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private String title;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "no_of_tickets", nullable = false)
    private int noOfTickets;

   @Column(nullable = false)
   private double price;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

	public TicketEntity(String type, String title, double unitPrice, int noOfTickets, double price,
			MovieEntity movie) {
		super();
		
		this.type = type;
		this.title = title;
		this.unitPrice = unitPrice;
		this.noOfTickets = noOfTickets;
		this.price = price;
		this.movie = movie;
	}

    // Getters and setters
}

