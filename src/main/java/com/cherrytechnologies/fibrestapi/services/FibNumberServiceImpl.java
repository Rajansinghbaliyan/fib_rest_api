package com.cherrytechnologies.fibrestapi.services;

import com.cherrytechnologies.fibrestapi.config.RestTemplateConfig;
import com.cherrytechnologies.fibrestapi.domain.FibNumber;
import com.cherrytechnologies.fibrestapi.repository.FibNumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.FibSeries;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FibNumberServiceImpl implements FibNumberService {

    private final FibNumberRepository repository;
    private final RestTemplate restTemplate;
    @Value("${WORKER_URL}")
    private String WORKER_URL;

    @Override
    public FibNumber getById(UUID uuid) {
        return null;
    }

    @Override
    @Cacheable(value = "fibNumberCache")
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
        fibNumber.setValue(getFionnaciValue(fibNumber.getNumber()));
        return repository.save(fibNumber);
    }

    @Override
    public void delete(UUID uuid) {

    }

    private int getFionnaciValue(int number) {
        log.info("GET "+ WORKER_URL+number);
        ResponseEntity<FibSeries> response = restTemplate
                .getForEntity(WORKER_URL +number, FibSeries.class);
        return response.getBody().getValue();
    }
}
