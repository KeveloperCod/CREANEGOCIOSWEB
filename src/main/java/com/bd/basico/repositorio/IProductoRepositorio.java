package com.bd.basico.repositorio;
import org.springframework.data.repository.CrudRepository;

import com.bd.basico.model.TblProducto;

public interface IProductoRepositorio extends CrudRepository<TblProducto,Integer>{

	
	
}//fin de la interface...
