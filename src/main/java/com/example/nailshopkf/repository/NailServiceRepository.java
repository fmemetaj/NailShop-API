package com.example.nailshopkf.repository;

import com.example.nailshopkf.entity.NailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NailServiceRepository extends JpaRepository<NailService, Long> {
}
