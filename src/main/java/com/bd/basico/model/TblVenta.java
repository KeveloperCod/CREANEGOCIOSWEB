package com.bd.basico.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_VENTA")
public class TblVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idventa;

    private String cliente;
    private String fecha;
    private double total;
    private String estado;

    // Relación OneToMany con TblDetalleVenta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TblDetalleVenta> detalles = new ArrayList<>();

    // Constructor vacío
    public TblVenta() {
    }

    // Getters y setters
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<TblDetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<TblDetalleVenta> detalles) {
        this.detalles = detalles;
    }

    // Método para agregar un detalle de venta
    public void agregarDetalleVenta(TblDetalleVenta detalleVenta) {
        detalles.add(detalleVenta);
        detalleVenta.setVenta(this);
    }

    @Override
    public String toString() {
        return "TblVenta [idventa=" + idventa + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + ", estado=" + estado + "]";
    }
}
