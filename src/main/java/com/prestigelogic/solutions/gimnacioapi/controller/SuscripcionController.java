package com.prestigelogic.solutions.gimnacioapi.controller;

import com.prestigelogic.solutions.gimnacioapi.model.Suscripcion;
import com.prestigelogic.solutions.gimnacioapi.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @GetMapping
    public List<Suscripcion> getAllSuscripcions() {
        return suscripcionRepository.findAll();
    }

    @PostMapping
    public Suscripcion createSuscripcion(@RequestBody Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suscripcion> getSuscripcionById(@PathVariable Long id) {
        return suscripcionRepository.findById(id)
                .map(suscripcion -> ResponseEntity.ok().body(suscripcion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suscripcion> updateSuscripcion(@PathVariable Long id, @RequestBody Suscripcion suscripcionDetails) {
        return suscripcionRepository.findById(id)
                .map(suscripcion -> {
                    suscripcion.setMiembro(suscripcionDetails.getMiembro());
                    suscripcion.setFechaFin(suscripcionDetails.getFechaFin());
                    suscripcion.setFechaInicio(suscripcionDetails.getFechaInicio());
                    suscripcion.setPrecio(suscripcionDetails.getPrecio());
                    suscripcion.setTipoSuscripcion(suscripcionDetails.getTipoSuscripcion());
                    Suscripcion updatedSuscripcion = suscripcionRepository.save(suscripcion);
                    return ResponseEntity.ok().body(updatedSuscripcion);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSuscripcion(@PathVariable Long id) {
        return suscripcionRepository.findById(id)
                .map(suscripcion -> {
                    suscripcionRepository.delete(suscripcion);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}