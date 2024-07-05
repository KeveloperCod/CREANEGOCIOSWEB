package com.bd.basico.servicio;

import java.util.List;
import com.bd.basico.model.TblEmpleado;

public interface IEmpleadoServicio {
    public List<TblEmpleado> ListadoEmpleado();
    public void RegistrarEmpleado(TblEmpleado empleado);
    public TblEmpleado BuscarPorId(Integer id);
    void ActualizarEmpleado(TblEmpleado empleado);
    public void Eliminar(Integer id);
    public TblEmpleado BuscarPorCodigoYPassword(String codigo, String password);
}
