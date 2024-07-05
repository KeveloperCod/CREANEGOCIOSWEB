package com.bd.basico.servicio;

import java.util.List;

import com.bd.basico.model.TblVenta;

public interface IVentaServicio {
    public List<TblVenta> ListadoVenta();
    public void RegistrarVenta(TblVenta venta);
    public TblVenta BuscarPorId(Integer idVenta);
    public void EliminarVenta(Integer idVenta);
}
