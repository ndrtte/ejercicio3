package hn.unah.poo.ejercicio3.Clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagoEmpleados {

    private String idEmpleado;

    private int horasTrabajadas;

    private double precioPorHora;
}
