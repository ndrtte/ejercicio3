package hn.unah.poo.ejercicio3.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoricoPagosDTO {

    private LocalDate fechaPago;

    private int horasTrabajadas;

    private double precioPorHora;

    private double totalSueldo;
}
