package com.enb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enb.entity.MovieEntity;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Long> {
}
