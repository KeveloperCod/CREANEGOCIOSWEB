package com.bd.basico.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.model.TblEmpleado;
import com.bd.basico.servicio.IEmpleadoServicio;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/vistas")
public class EmpleadoController {

    @Autowired
    private IEmpleadoServicio iempleadoservicio;

    @GetMapping("ListadoEmpleado")
    public String ListadoEmpleado(Model modelo) {
        List<TblEmpleado> listado = iempleadoservicio.ListadoEmpleado();
        for (TblEmpleado lis : listado) {
	        System.out.println("codigo " + lis.getIdEmpleado() + " " + " nombre " + lis.getNombre());
       }
        // Enviamos la data hacia la vista
        modelo.addAttribute("listado", listado);
        // Retornamos
        return "/Vistas/ListadoEmpleado";
    }

    @GetMapping("/RegistrarEmpleado")
    public String RegistrarEmpleado(Model modelo) {
        TblEmpleado empleado = new TblEmpleado();
        modelo.addAttribute("regempleado", empleado);
        return "/Vistas/RegistrarEmpleado";
    }

 // Método para guardar un nuevo producto
    @PostMapping("/GuardarEmpleado")
    public String GuardarEmpleado(@ModelAttribute TblEmpleado empleado, Model modelo) {
        iempleadoservicio.RegistrarEmpleado(empleado);
        System.out.println("dato registrado en la bd");
        return "redirect:/vistas/ListadoEmpleado";
    }// Fin del método guardar producto

    @GetMapping("/editarEmpleado/{id}")
    public String EditarEmpleado(@PathVariable("id") Integer idEmpleado, Model modelo) {
        TblEmpleado empleado = iempleadoservicio.BuscarPorId(idEmpleado);
        modelo.addAttribute("regempleado", empleado);
        return "/Vistas/RegistrarEmpleado";
    }
    
    @GetMapping("/eliminarEmpleado/{id}")
    public String EliminarEmpleado(@PathVariable("id") Integer idEmpleado, Model modelo) {
        iempleadoservicio.Eliminar(idEmpleado);
        return "redirect:/vistas/ListadoEmpleado";
    }
}
