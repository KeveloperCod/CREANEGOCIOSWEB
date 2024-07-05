package com.bd.basico.servicio;

import java.util.List;
import com.bd.basico.model.TblDetalleVenta;

public interface IDetalleVentaServicio {
    List<TblDetalleVenta> ListadoDetalleVenta();
    void RegistrarDetalleVenta(TblDetalleVenta detalleVenta);
    TblDetalleVenta BuscarDetallePorId(Integer idDetalleVenta);
    void EliminarDetalleVenta(Integer idDetalleVenta);
}
