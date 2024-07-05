package com.bd.basico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_detalleventa")
public class TblDetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private TblVenta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private TblProducto producto;

    private int cantidad;
    private double precioUnitario;

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public TblVenta getVenta() {
        return venta;
    }

    public void setVenta(TblVenta venta) {
        this.venta = venta;
    }

    public TblProducto getProducto() {
        return producto;
    }

    public void setProducto(TblProducto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
