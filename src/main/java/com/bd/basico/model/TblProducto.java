package com.bd.basico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCTO")
public class TblProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;

    private String nombre;
    private double precioventa;
    private int stock;
    private double preciocomp;
    private String estado;
    private String descrip;

    public TblProducto() {
    }

    public int getIdproducto() {
        return this.idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioventa() {
        return this.precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPreciocomp() {
        return this.preciocomp;
    }

    public void setPreciocomp(double preciocomp) {
        this.preciocomp = preciocomp;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescrip() {
        return this.descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

	@Override
	public String toString() {
		return "TblProducto [idproducto=" + idproducto + ", nombre=" + nombre + ", precioventa="
				+ precioventa + ", stock=" + stock + ", preciocomp=" + preciocomp + ", estado=" + estado
				+ ", descrip=" + descrip + "]";
	} //fin del metodo toString
	
    
    
}