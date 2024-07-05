package com.bd.basico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.model.TblDetalleVenta;
import com.bd.basico.model.TblProducto;
import com.bd.basico.model.TblVenta;
import com.bd.basico.servicio.IProductoServicio;
import com.bd.basico.servicio.IVentaServicio;

@Controller
@RequestMapping("/vistas")
public class VentaController {

    @Autowired
    private IVentaServicio ventaServicio;

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/RegistrarVenta")
    public String registrarVenta(Model modelo) {
        List<TblProducto> listaProductos = productoServicio.ListadoProducto(); // Cambiado a minúscula por convención
        TblVenta venta = new TblVenta();
        TblDetalleVenta detalleVenta = new TblDetalleVenta();
        venta.agregarDetalleVenta(detalleVenta);

        modelo.addAttribute("venta", venta);
        modelo.addAttribute("productos", listaProductos); // Asegúrate de que el nombre coincida con la vista

        return "/Vistas/RegistrarVenta";
    }

    @PostMapping("/GuardarVenta")
    public String guardarVenta(@ModelAttribute("venta") TblVenta venta, Model modelo) {
    	for (TblDetalleVenta detalle : venta.getDetalles()) {
            // Obtener el producto asociado al detalle
            TblProducto producto = detalle.getProducto();
            // Asignar el estado del producto como estado de la venta
            venta.setEstado(producto.getEstado());
        }
        ventaServicio.RegistrarVenta(venta);
        return "redirect:/vistas/ListadoVenta";
    }

    @GetMapping("/ListadoVenta")
    public String listadoVenta(Model modelo) {
        List<TblVenta> listadoVentas = ventaServicio.ListadoVenta();
        modelo.addAttribute("listadoVentas", listadoVentas);
        return "/Vistas/ListadoVenta";
    }
    
    @GetMapping("/EditarVenta/{id}")
    public String editarVenta(@PathVariable("id") int idVenta, Model modelo) {
        TblVenta venta = ventaServicio.BuscarPorId(idVenta);
        List<TblProducto> listaProductos = productoServicio.ListadoProducto(); // Asegúrate de que el servicio esté disponible y correctamente autowired

        modelo.addAttribute("venta", venta);
        modelo.addAttribute("productos", listaProductos);

        return "/Vistas/RegistrarVenta"; // Asegúrate de que la vista exista y esté correctamente nombrada
    }
    // Método para eliminar una venta
    @GetMapping("/EliminarVenta/{id}")
    public String eliminarVenta(@PathVariable("id") Integer id) {
        ventaServicio.EliminarVenta(id);
        return "redirect:/vistas/ListadoVenta";
    }
    
    
    
}
