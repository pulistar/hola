package com.basesdedatos.model;


public class ContratoAlquiler {
    private int idContrato;
    private int idInquilino;
    private int idPropietario;
    private int idPropiedad;
    private double precioAlquiler;
    private String formaPago;



    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        return "ContratoAlquiler{" +
                "idContrato=" + idContrato +
                ", idInquilino=" + idInquilino +
                ", idPropietario=" + idPropietario +
                ", idPropiedad=" + idPropiedad +
                ", precioAlquiler=" + precioAlquiler +
                ", formaPago='" + formaPago + '\'' +
                '}';
    }
}
