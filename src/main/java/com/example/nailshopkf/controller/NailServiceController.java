package com.example.nailshopkf.controller;

import com.example.nailshopkf.entity.NailService;
import com.example.nailshopkf.exceptions.NailServiceNotFoundException;
import com.example.nailshopkf.service.NailServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nailServices")
public class NailServiceController {

    private final NailServiceService nailServiceService;

    public NailServiceController(NailServiceService nailServiceService) {
        this.nailServiceService = nailServiceService;
    }

    @PostMapping
    public ResponseEntity<NailService> createNailService(@RequestBody NailService nailService) {
        return new ResponseEntity<>(nailServiceService.createNailService(nailService), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NailService>> getAllNailServices() {
        return new ResponseEntity<>(nailServiceService.getAllNailServices(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NailService> getNailServiceById(@PathVariable Long id) {
        return new ResponseEntity<>(nailServiceService.getNailServiceById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NailService> updateNailService(@PathVariable Long id, @RequestBody NailService nailService) {
        return new ResponseEntity<>(nailServiceService.updateNailService(id, nailService), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNailService(@PathVariable Long id) {
        nailServiceService.deleteNailService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NailServiceNotFoundException.class)
    public ResponseEntity<String> handleNailServiceNotFoundException(NailServiceNotFoundException exception) {
        return new ResponseEntity<>("Nail Service not found", HttpStatus.NOT_FOUND);
    }
}
