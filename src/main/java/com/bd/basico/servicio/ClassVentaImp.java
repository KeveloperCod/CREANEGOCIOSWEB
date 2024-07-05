package com.bd.basico.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.basico.model.TblVenta;
import com.bd.basico.repositorio.IVentaRepositorio;

@Service
public class ClassVentaImp implements IVentaServicio {

    @Autowired
    private IVentaRepositorio ventaRepositorio;

    @Override
    public List<TblVenta> ListadoVenta() {
        return (List<TblVenta>) ventaRepositorio.findAll();
    }

    @Override
    public void RegistrarVenta(TblVenta venta) {
        ventaRepositorio.save(venta);
    }

    @Override
    public TblVenta BuscarPorId(Integer idVenta) {
        Optional<TblVenta> ventaOptional = ventaRepositorio.findById(idVenta);
        return ventaOptional.orElse(null); // Devuelve la venta si se encuentra, o null si no se encuentra
    }

    @Override
    public void EliminarVenta(Integer idVenta) {
        ventaRepositorio.deleteById(idVenta);
    }
}
