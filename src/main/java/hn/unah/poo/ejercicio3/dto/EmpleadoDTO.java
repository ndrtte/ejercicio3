package hn.unah.poo.ejercicio3.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private String dni;

    private String nombre;

    private String apellido;

    private LocalDate fechaIngreso;

    private List<HistoricoPagosDTO> historicoPagos;
}
