package hn.unah.poo.ejercicio3.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.poo.ejercicio3.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado,String> {
    
}
