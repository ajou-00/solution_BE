package com.ajou00.solution.repository;

import com.ajou00.solution.domain.Random;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandomRepository extends JpaRepository<Random,Long> {
    List<Random> findByUserName(String userName);
    List<Random> findByOrderId(Long id);
}
