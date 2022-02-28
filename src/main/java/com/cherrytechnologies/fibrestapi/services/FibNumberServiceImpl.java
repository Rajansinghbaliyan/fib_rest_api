package com.cherrytechnologies.fibrestapi.services;

import com.cherrytechnologies.fibrestapi.domain.FibNumber;
import com.cherrytechnologies.fibrestapi.repository.FibNumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FibNumberServiceImpl implements FibNumberService {

    private final FibNumberRepository repository;

    @Override
    public FibNumber getById(UUID uuid) {
        return null;
    }

    @Override
    public FibNumber getByValue(int number) {
        return repository.findByNumber(number);
    }

    @Override
    public List<FibNumber> getAll() {
        return repository.findAll();
    }

    @Override
    public FibNumber create(FibNumber fibNumber) {
        fibNumber.setId(null);
        return repository.save(fibNumber);
    }

    @Override
    public void delete(UUID uuid) {

    }
}
