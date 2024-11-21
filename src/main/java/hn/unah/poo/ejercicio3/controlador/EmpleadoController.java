package hn.unah.poo.ejercicio3.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.poo.ejercicio3.Clases.PagoEmpleados;
import hn.unah.poo.ejercicio3.Clases.PagosEspecificos;
import hn.unah.poo.ejercicio3.dto.EmpleadoDTO;
import hn.unah.poo.ejercicio3.servicio.EmpleadoServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @PostMapping("/crear/nuevo")
    public String crearEmpleado(@RequestBody EmpleadoDTO nvoEmpleado){
        return empleadoServicio.crearEmpleado(nvoEmpleado);
    }

    @DeleteMapping("/eliminar/dni")
    public String eliminarEmpleado(@RequestParam(name="dni")String dni){
        return empleadoServicio.eliminarEmpleado(dni);
    }

    @GetMapping("/obtener/dni")
    public EmpleadoDTO obtenerEmpleado(@RequestParam(name="dni")String dni) {
        return empleadoServicio.obtenerEmpleado(dni);
    }

    @GetMapping("/obtener")
    public List<EmpleadoDTO> obtenerTodos() {
        return empleadoServicio.obtenerTodos();    
    }

    @GetMapping("/obtener/pagos")
    public List<String> obtenerPagos(@RequestBody PagosEspecificos pagosEspecificos) {
        return empleadoServicio.obtenerPagos(pagosEspecificos);
    }

    @PostMapping("/crear/pago")
    public String crearPagoEmpleado(@RequestBody PagoEmpleados pagosEmpleados){
        return empleadoServicio.crearPagoEmpleado(pagosEmpleados);
    }

    
}
