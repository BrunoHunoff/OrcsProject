package com.orcs.orcamentos.controllers;

import com.orcs.orcamentos.dtos.OrcDto;
import com.orcs.orcamentos.models.OrcModel;
import com.orcs.orcamentos.repositories.OrcRepository;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class OrcController {

    @Autowired
    OrcRepository orcRepository;

    @PostMapping("/orcs")
    public ResponseEntity<OrcModel> saveOrc(@RequestBody @Valid OrcDto orcDto) {
        var orcModel = new OrcModel();
        BeanUtils.copyProperties(orcDto, orcModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(orcRepository.save(orcModel));
    }

    @GetMapping("/orcs")
    public ResponseEntity<List<OrcModel>> getAllOrcs() {
        return ResponseEntity.status(HttpStatus.OK).body(orcRepository.findAll());
    }

    @GetMapping("/orcs/{id}")
    public ResponseEntity<Object> getOneOrc(@PathVariable int id) {
        Optional<OrcModel> orcO = orcRepository.findByIdOrc(id);
        if (orcO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quote not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(orcO.get());
    }

    @PutMapping("orcs/{id}")
    public ResponseEntity<Object> updateOrc(@PathVariable int id, @RequestBody OrcDto orcDto) {
        Optional<OrcModel> orcO = orcRepository.findByIdOrc(id);
        if (orcO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quote not found.");
        }
        var orcModel = orcO.get();
        BeanUtils.copyProperties(orcDto, orcModel);
        return ResponseEntity.status(HttpStatus.OK).body(orcRepository.save(orcModel));
    }

    @DeleteMapping("orcs/{id}")
    public ResponseEntity<Object> deleteOrc(@PathVariable int id) {
        Optional<OrcModel> orcO = orcRepository.findByIdOrc(id);
        if (orcO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quote not found.");
        }
        var orcModel = orcO.get();
        orcRepository.delete(orcModel);
        return ResponseEntity.status(HttpStatus.OK).body("Quote deleted Successfully.");
    }
}
