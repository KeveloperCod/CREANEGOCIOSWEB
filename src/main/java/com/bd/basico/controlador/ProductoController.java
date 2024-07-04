package com.bd.basico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.model.TblProducto;
import com.bd.basico.servicio.IProductoServicio;

import org.springframework.ui.Model;
@Controller
@RequestMapping("/vistas")
public class ProductoController {

	// Inyección de dependencia
	@Autowired
	private IProductoServicio iproductoservicio;

	// Método para listar productos
	@GetMapping("ListadoProducto")
	public String ListadoProducto(Model modelo) {
	    // Recuperamos el listado de productos
	    List<TblProducto> listado = iproductoservicio.ListadoProducto();
	    for (TblProducto lis : listado) {
	        System.out.println("codigo " + lis.getIdproducto() + " " + " nombre " + lis.getNombre());
	    }
	    // Enviamos la data hacia la vista
	    modelo.addAttribute("listado", listado);
	    // Retornamos
	    return "/Vistas/ListadoProducto";
	} // Fin del método listado producto

	// Método para registrar un nuevo producto
	@GetMapping("/RegistrarProducto")
	public String RegistrarProducto(Model modelo) {
	    // Realizamos la respectiva instancia
	    TblProducto producto = new TblProducto();
	    // Enviamos a la vista
	    modelo.addAttribute("regproducto", producto);
	    // Retornamos
	    return "/Vistas/RegistrarProducto";
	} // Fin del método registrar

	// Método para guardar un nuevo producto
	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute TblProducto producto, Model modelo) {
	    iproductoservicio.RegistrarProducto(producto);
	    System.out.println("dato registrado en la bd");
	    // Retornamos al listado
	    return "redirect:/vistas/ListadoProducto";
	} // Fin del método guardar producto

	// Método para editar un producto existente
	@GetMapping("/editar/{id}")
	public String Editar(@PathVariable("id") Integer idproducto, Model modelo) {
	    TblProducto producto = iproductoservicio.BuscarPorId(idproducto);
	    // Enviamos hacia la vista
	    modelo.addAttribute("regproducto", producto);
	    // Retornamos el formulario para crear producto
	    return "/Vistas/RegistrarProducto";
	} // Fin del método editar

	// Método para Eliminar un producto existente
	@GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer idProducto, Model modelo) {
        iproductoservicio.Eliminar(idProducto);
        System.out.println("dato Eliminado en la bd");
        return "redirect:/vistas/ListadoProducto";
    }
	
} //fin del controlador
