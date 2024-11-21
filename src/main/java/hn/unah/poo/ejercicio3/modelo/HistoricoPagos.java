package hn.unah.poo.ejercicio3.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="historicopagos")
public class HistoricoPagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idhp")
    private int idHP;
    
    @Column(name="fechapago")
    private LocalDate fechaPago;

    @Column(name="horastrabajadas")
    private int horasTrabajadas;

    @Column(name="precioporhora")
    private double precioPorHora;

    @Column(name="totalsueldo")
    private double totalSueldo;

    @ManyToOne()
    @JoinColumn(name="dni",referencedColumnName = "dni")
    @JsonIgnore
    private Empleado empleado;
}
