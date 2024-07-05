package com.bd.basico.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd.basico.model.TblEmpleado;
import com.bd.basico.repositorio.IEmpleadoRepositorio;

@Service
@Transactional
public class ClassEmpleadoImp implements IEmpleadoServicio {


@Autowired
    private IEmpleadoRepositorio iEmpleadoRepositorio;

    @Override
    public List<TblEmpleado> ListadoEmpleado() {
        return (List<TblEmpleado>) iEmpleadoRepositorio.findAll();
    }

    @Override
    public void RegistrarEmpleado(TblEmpleado empleado) {
        iEmpleadoRepositorio.save(empleado);
    }

    @Override
    public TblEmpleado BuscarPorId(Integer id) {
        return iEmpleadoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void Eliminar(Integer id) {
        iEmpleadoRepositorio.deleteById(id);
    }

	@Override
	public TblEmpleado BuscarPorCodigoYPassword(String codigo, String password) {
		return iEmpleadoRepositorio.findByCodigoAndPassword(codigo, password);
	}

	@Override
	public void ActualizarEmpleado(TblEmpleado empleado) {
		iEmpleadoRepositorio.save(empleado);
		
	}

}
