package com.juego.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juego.domain.Referido;

@Repository
public interface ReferidoRepository extends JpaRepository<Referido, Long> {

}
