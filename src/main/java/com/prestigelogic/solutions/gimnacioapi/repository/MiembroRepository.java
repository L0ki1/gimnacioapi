package com.prestigelogic.solutions.gimnacioapi.repository;

import com.prestigelogic.solutions.gimnacioapi.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro, Long> {
}
