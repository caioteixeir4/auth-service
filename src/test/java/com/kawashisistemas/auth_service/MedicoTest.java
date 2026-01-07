package com.kawashisistemas.auth_service;

import org.junit.jupiter.api.Test;

import com.kawashisistemas.auth_service.model.Endereco;
import com.kawashisistemas.auth_service.model.Medico;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {

    @Test
    void deveCriarMedicoComSucesso() {
        // Ordem: logradouro, bairro, cep, cidade, uf, numero, complemento
        Endereco endereco = new Endereco("Rua Teste", "Bairro", "12345678", "Cidade", "UF", "10", "Apto 1");
        
        // Ordem correta do construtor da sua classe Medico:
        // id, nome, email, crm, endereco, ativo
        Medico medico = new Medico(null, "Dr. Caio", "caio@teste.com", "CRM123", endereco, true);

        assertEquals("Dr. Caio", medico.getNome());
        assertEquals("CRM123", medico.getCrm());
        assertNotNull(medico.getEndereco());
        assertTrue(medico.getAtivo());
    }
}