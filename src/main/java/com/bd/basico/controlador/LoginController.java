package com.bd.basico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bd.basico.model.TblEmpleado;
import com.bd.basico.servicio.IEmpleadoServicio;

@Controller
@RequestMapping("/vistas")
public class LoginController {

    @Autowired
    private IEmpleadoServicio iEmpleadoServicio;

    // Método GET para mostrar el formulario de login
    @GetMapping("/Login")
    public String mostrarFormularioLogin() {
        return "/Vistas/LoginEmpleado";
    }

    // Método POST para procesar el login del empleado
    @PostMapping("/LoginEmpleado")
    public String loginEmpleado(@RequestParam("codigo") String codigo, 
                                @RequestParam("password") String password, Model modelo) {
        TblEmpleado empleado = iEmpleadoServicio.BuscarPorCodigoYPassword(codigo, password);
        if (empleado != null) {
            modelo.addAttribute("empleado", empleado);
            return "redirect:/vistas/Mantenimiento"; // Redirigir a la página de reporte después del login exitoso
        } else {
            modelo.addAttribute("error", "Código o password incorrectos");
            return "/Vistas/LoginEmpleado";
        }
    }
}
