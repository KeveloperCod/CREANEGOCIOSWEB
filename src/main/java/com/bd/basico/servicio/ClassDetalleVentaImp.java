package com.bd.basico.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bd.basico.model.TblDetalleVenta;
import com.bd.basico.repositorio.IDetalleVentaRepositorio;

@Service
@Transactional
public class ClassDetalleVentaImp implements IDetalleVentaServicio {

    @Autowired
    private IDetalleVentaRepositorio detalleVentaRepositorio;

    @Override
    public List<TblDetalleVenta> ListadoDetalleVenta() {
        return (List<TblDetalleVenta>) detalleVentaRepositorio.findAll();
    }

    @Override
    public void RegistrarDetalleVenta(TblDetalleVenta detalleVenta) {
        detalleVentaRepositorio.save(detalleVenta);
    }

    @Override
    public TblDetalleVenta BuscarDetallePorId(Integer idDetalleVenta) {
        return detalleVentaRepositorio.findById(idDetalleVenta).orElse(null);
    }

    @Override
    public void EliminarDetalleVenta(Integer idDetalleVenta) {
        detalleVentaRepositorio.deleteById(idDetalleVenta);
    }
}
