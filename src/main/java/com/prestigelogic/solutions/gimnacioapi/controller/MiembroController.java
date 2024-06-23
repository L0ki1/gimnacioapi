package com.prestigelogic.solutions.gimnacioapi.controller;


import com.prestigelogic.solutions.gimnacioapi.model.Miembro;
import com.prestigelogic.solutions.gimnacioapi.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miembros")
public class MiembroController {

    @Autowired
    private MiembroRepository miembroRepository;

    @GetMapping
    public List<Miembro> getAllMiembros() {
        return miembroRepository.findAll();
    }

    @PostMapping
    public Miembro createMiembro(@RequestBody Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembro> getMiembroById(@PathVariable Long id) {
        return miembroRepository.findById(id)
                .map(miembro -> ResponseEntity.ok().body(miembro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miembro> updateMiembro(@PathVariable Long id, @RequestBody Miembro miembroDetails) {
        return miembroRepository.findById(id)
                .map(miembro -> {
                    miembro.setNombre(miembroDetails.getNombre());
                    miembro.setApellido(miembroDetails.getApellido());
                    miembro.setFechaDeNacimiento(miembroDetails.getFechaDeNacimiento());
                    miembro.setEmail(miembroDetails.getEmail());
                    miembro.setTelefono(miembroDetails.getTelefono());
                    Miembro updatedMiembro = miembroRepository.save(miembro);
                    return ResponseEntity.ok().body(updatedMiembro);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMiembro(@PathVariable Long id) {
        return miembroRepository.findById(id)
                .map(miembro -> {
                    miembroRepository.delete(miembro);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
