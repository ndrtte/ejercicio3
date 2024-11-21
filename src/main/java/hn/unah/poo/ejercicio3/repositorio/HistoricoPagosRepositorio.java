package hn.unah.poo.ejercicio3.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.poo.ejercicio3.modelo.HistoricoPagos;

public interface HistoricoPagosRepositorio extends JpaRepository<HistoricoPagos,Integer> {
    
}
