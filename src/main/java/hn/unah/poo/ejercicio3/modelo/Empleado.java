package hn.unah.poo.ejercicio3.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="empleado")
public class Empleado {
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    @Column(name="fechaingreso")
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<HistoricoPagos> listaHistoricoPagos;
}
