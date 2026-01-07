package com.kawashisistemas.auth_service.repository;
import com.kawashisistemas.auth_service.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicoRepository extends JpaRepository<Medico, Long> {}