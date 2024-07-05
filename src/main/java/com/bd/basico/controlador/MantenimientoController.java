package com.bd.basico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.model.TblEmpleado;
import com.bd.basico.model.TblProducto;
import com.bd.basico.servicio.IEmpleadoServicio;
import com.bd.basico.servicio.IProductoServicio;

@Controller
@RequestMapping("/vistas")

public class MantenimientoController {
	 @Autowired
	    private IEmpleadoServicio empleadoServicio;

	    @Autowired
	    private IProductoServicio productoServicio;

	    @GetMapping("/Mantenimiento")
	    public String mostrarReporte(Model modelo) {
	        List<TblEmpleado> empleados = empleadoServicio.ListadoEmpleado();
	        List<TblProducto> productos = productoServicio.ListadoProducto();

	        modelo.addAttribute("empleados", empleados);
	        modelo.addAttribute("productos", productos);

	        return "/Vistas/Mantenimiento";
	    }

}
