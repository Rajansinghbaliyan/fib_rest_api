package com.cherrytechnologies.fibrestapi.controllers;

import com.cherrytechnologies.fibrestapi.domain.FibNumber;
import com.cherrytechnologies.fibrestapi.services.FibNumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fib-number")
@Slf4j
@RequiredArgsConstructor
public class FibNumberController {

    private final FibNumberService fibNumberService;

    @GetMapping("/{id}")
    public ResponseEntity<FibNumber> getByValue(@PathVariable Integer id) {
        log.info("GET /api/v1/fib-number/" + id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .location(URI.create("/api/v1/fib-number/" + id))
                .body(fibNumberService.getByValue(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<FibNumber>> getAll() {
        log.info("GET /api/v1/fib-number/");
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .location(URI.create("/api/v1/fib-number/"))
                .body(fibNumberService.getAll());

    }

    @PostMapping("/")
    public ResponseEntity<FibNumber> create(@RequestBody FibNumber fibNumber) {
        log.info("POST /api/v1/fib-number/");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .location(URI.create("/api/v1/fib-number/"))
                .body(fibNumberService.create(fibNumber));
    }

}
