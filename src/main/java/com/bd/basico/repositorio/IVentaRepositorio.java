package com.bd.basico.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.bd.basico.model.TblVenta;

public interface IVentaRepositorio extends CrudRepository<TblVenta, Integer> {

}
