package com.cherrytechnologies.fibrestapi.services;

import com.cherrytechnologies.fibrestapi.domain.FibNumber;

import java.util.List;
import java.util.UUID;

public interface FibNumberService {
    FibNumber getById(UUID uuid);
    FibNumber getByValue(int number);
    List<FibNumber> getAll();
    FibNumber create(FibNumber fibNumber);
    void delete(UUID uuid);
}
