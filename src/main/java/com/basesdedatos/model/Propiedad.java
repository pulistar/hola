package com.basesdedatos.model;

public class Propiedad {
    private int idPropiedad;
    private int numEstrato;
    private String barrio;
    private int numHabitaciones;
    private int numPisos;
    private double areaDePropiedad;
    private int antiguedadInmueble;
    private int numParqueaderos;
    private String inquilinos;
    private String propiedadescol;


    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public int getNumEstrato() {
        return numEstrato;
    }

    public void setNumEstrato(int numEstrato) {
        this.numEstrato = numEstrato;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public double getAreaDePropiedad() {
        return areaDePropiedad;
    }

    public void setAreaDePropiedad(double areaDePropiedad) {
        this.areaDePropiedad = areaDePropiedad;
    }

    public int getAntiguedadInmueble() {
        return antiguedadInmueble;
    }

    public void setAntiguedadInmueble(int antiguedadInmueble) {
        this.antiguedadInmueble = antiguedadInmueble;
    }

    public int getNumParqueaderos() {
        return numParqueaderos;
    }

    public void setNumParqueaderos(int numParqueaderos) {
        this.numParqueaderos = numParqueaderos;
    }

    public String getInquilinos() {
        return inquilinos;
    }

    public void setInquilinos(String inquilinos) {
        this.inquilinos = inquilinos;
    }

    public String getPropiedadescol() {
        return propiedadescol;
    }

    public void setPropiedadescol(String propiedadescol) {
        this.propiedadescol = propiedadescol;
    }

    

    @Override
    public String toString() {
        return "Propiedad{" +
                "idPropiedad=" + idPropiedad +
                ", numEstrato=" + numEstrato +
                ", barrio='" + barrio + '\'' +
                ", numHabitaciones=" + numHabitaciones +
                ", numPisos=" + numPisos +
                ", areaDePropiedad=" + areaDePropiedad +
                ", antiguedadInmueble=" + antiguedadInmueble +
                ", numParqueaderos=" + numParqueaderos +
                ", inquilinos=" + inquilinos +
                ", propiedadesCol='" + propiedadescol + '\'' +
                '}';
    }
}
