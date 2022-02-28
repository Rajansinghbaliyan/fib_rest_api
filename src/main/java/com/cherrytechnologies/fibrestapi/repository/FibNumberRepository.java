package com.cherrytechnologies.fibrestapi.repository;

import com.cherrytechnologies.fibrestapi.domain.FibNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FibNumberRepository extends JpaRepository<FibNumber, UUID> {
    FibNumber findByNumber(int number);
}
