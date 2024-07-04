package com.bd.basico.servicio;

import java.util.List;

import com.bd.basico.model.TblProducto;

public interface IProductoServicio {
    
    // Declaramos los métodos
    public List<TblProducto> ListadoProducto();
    public void RegistrarProducto(TblProducto producto);
    public TblProducto BuscarPorId(Integer id);
    public void Eliminar(Integer id);
}
