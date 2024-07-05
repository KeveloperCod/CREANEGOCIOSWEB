package com.bd.basico.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.bd.basico.model.TblEmpleado;

public interface IEmpleadoRepositorio extends CrudRepository<TblEmpleado, Integer> {
	TblEmpleado findByCodigoAndPassword(String codigo, String password);
}
