package com.prestigelogic.solutions.gimnacioapi.controller;

import com.prestigelogic.solutions.gimnacioapi.model.Pago;
import com.prestigelogic.solutions.gimnacioapi.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    @PostMapping
    public Pago createPago(@RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        return pagoRepository.findById(id)
                .map(pago -> ResponseEntity.ok().body(pago))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable Long id, @RequestBody Pago pagoDetails) {
        return pagoRepository.findById(id)
                .map(pago -> {
                    pago.setMiembro(pagoDetails.getMiembro());
                    pago.setMonto(pagoDetails.getMonto());
                    pago.setSuscripcion(pagoDetails.getSuscripcion());
                    pago.setMetodoPago(pagoDetails.getMetodoPago());
                    pago.setFechaPago(pagoDetails.getFechaPago());
                    Pago updatedPago = pagoRepository.save(pago);
                    return ResponseEntity.ok().body(updatedPago);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePago(@PathVariable Long id) {
        return pagoRepository.findById(id)
                .map(pago -> {
                    pagoRepository.delete(pago);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
