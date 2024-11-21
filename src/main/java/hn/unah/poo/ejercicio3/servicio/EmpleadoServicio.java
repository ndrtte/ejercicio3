package hn.unah.poo.ejercicio3.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import hn.unah.poo.ejercicio3.Clases.PagoEmpleados;
import hn.unah.poo.ejercicio3.Clases.PagosEspecificos;
import hn.unah.poo.ejercicio3.ModelMapper.ModelMapperSingleton;
import hn.unah.poo.ejercicio3.dto.EmpleadoDTO;
import hn.unah.poo.ejercicio3.modelo.Empleado;
import hn.unah.poo.ejercicio3.modelo.HistoricoPagos;
import hn.unah.poo.ejercicio3.repositorio.EmpleadoRepositorio;
import hn.unah.poo.ejercicio3.repositorio.HistoricoPagosRepositorio;

@Service
public class EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    private ModelMapper modelMapper = ModelMapperSingleton.getInstancia();

    @Autowired
    private HistoricoPagosRepositorio historicoPagosRepositorio;

    
    public String crearEmpleado(@RequestBody EmpleadoDTO nvoEmpleado){
        if(empleadoRepositorio.existsById(nvoEmpleado.getDni())){
            return "Este empleado ya existe";
        }
        Empleado empleado = new Empleado();
        empleado = modelMapper.map(nvoEmpleado, Empleado.class);
        empleadoRepositorio.save(empleado);
        return "El cliente ha sido creado";
    }

    public String eliminarEmpleado(@RequestParam(name="dni")String dni){
        if(!empleadoRepositorio.existsById(dni)){
            return "Este empleado no existe";
        }
        empleadoRepositorio.deleteById(dni);
        return "Este empleado ha sido borrado con exito";
    }

    public EmpleadoDTO obtenerEmpleado(String dni) {
        if(empleadoRepositorio.existsById(dni)){
            Optional <Empleado> empleado = empleadoRepositorio.findById(dni);
            EmpleadoDTO empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);
            return empleadoDTO;
        }
            return null;
    }

    public List<EmpleadoDTO> obtenerTodos(){
        List<Empleado> listaEmpleados = empleadoRepositorio.findAll();
        List<EmpleadoDTO> listaEmpleadosDTO = new ArrayList<>();
        EmpleadoDTO empleadoDTO;
        for (Empleado empleado : listaEmpleados) {
            empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);
            listaEmpleadosDTO.add(empleadoDTO);
        }
        return listaEmpleadosDTO;
    }

    public List<String> obtenerPagos(PagosEspecificos pagosEspecificos) {
        String dni = pagosEspecificos.getIdEmpleado();
        Optional<Empleado> empleado = empleadoRepositorio.findById(dni);
        
        List<String> listaPagos = new ArrayList<>();

        if (empleado.isEmpty()) {
            listaPagos.add("No existe el empleado con idEmpleado: " + dni);
        } else {
            List<HistoricoPagos> listaHistorialPagos = empleado.get().getListaHistoricoPagos();
            
            for (HistoricoPagos historicoPagos : listaHistorialPagos) {
                LocalDate fechaPago = historicoPagos.getFechaPago();
                
                if ((fechaPago.isEqual(pagosEspecificos.getFechaInicio()) || fechaPago.isAfter(pagosEspecificos.getFechaInicio())) &&
                        (fechaPago.isEqual(pagosEspecificos.getFechaFin()) || fechaPago.isBefore(pagosEspecificos.getFechaFin()))) {
                    
                    String mostrarPago = "Fecha: " + fechaPago+
                                         "Total sueldo: " +historicoPagos.getTotalSueldo();
                    
                    listaPagos.add(mostrarPago);
                }
            }
        }
        
        return listaPagos;
    }

    public String crearPagoEmpleado(PagoEmpleados pagoEmpleados){
        Optional <Empleado> empleado = empleadoRepositorio.findById(pagoEmpleados.getIdEmpleado());
        int horasTrabajadas = pagoEmpleados.getHorasTrabajadas();
        double precioPorHora = pagoEmpleados.getPrecioPorHora();
        if(empleado.isEmpty() || horasTrabajadas < 0 || precioPorHora < 0){
            return "Informacion digitada no valida";
        }
        HistoricoPagos historicoPagos = new HistoricoPagos();
        historicoPagos.setEmpleado(empleado.get());
        historicoPagos.setHorasTrabajadas(horasTrabajadas);
        historicoPagos.setPrecioPorHora(precioPorHora);
        historicoPagos.setFechaPago(LocalDate.now());
        historicoPagos.setTotalSueldo(horasTrabajadas * precioPorHora);

        historicoPagosRepositorio.save(historicoPagos);
        return "Pago creado con exito para empleado: " +empleado.get().getDni();
    }



    

}
