package hn.unah.poo.ejercicio3.Clases;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagosEspecificos {
    
    private String idEmpleado;
    
    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
