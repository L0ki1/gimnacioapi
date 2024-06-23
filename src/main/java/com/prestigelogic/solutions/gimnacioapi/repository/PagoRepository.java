package com.prestigelogic.solutions.gimnacioapi.repository;


import com.prestigelogic.solutions.gimnacioapi.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}
