package com.example.nailshopkf.service;

import com.example.nailshopkf.entity.NailService;
import com.example.nailshopkf.exceptions.NailServiceNotFoundException;
import com.example.nailshopkf.repository.NailServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NailServiceService {

    private final NailServiceRepository nailServiceRepository;

    public NailServiceService(NailServiceRepository nailServiceRepository) {
        this.nailServiceRepository = nailServiceRepository;
    }

    public List<NailService> getAllNailServices() {
        return nailServiceRepository.findAll();
    }

    public NailService getNailServiceById(Long id) {
        return nailServiceRepository.findById(id).orElseThrow(NailServiceNotFoundException::new);
    }

    public NailService createNailService(NailService nailService) {
        return nailServiceRepository.save(nailService);
    }

    public NailService updateNailService(Long id, NailService nailService) {
        return nailServiceRepository.findById(id)
                .map(existingNailService -> {
                    nailService.setId(id);
                    return nailServiceRepository.save(nailService);
                })
                .orElseThrow(NailServiceNotFoundException::new);
    }

    public void deleteNailService(Long id) {
        nailServiceRepository.findById(id)
                .orElseThrow(NailServiceNotFoundException::new);
        nailServiceRepository.deleteById(id);
    }
}
