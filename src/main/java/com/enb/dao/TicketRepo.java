package com.enb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enb.entity.TicketEntity;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity, Integer> {

	List<TicketEntity> findAllByMovieId(Long movieId);
}
