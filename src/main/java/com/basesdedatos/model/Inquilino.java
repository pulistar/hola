package com.basesdedatos.model;

public class Inquilino {
    private int idInquilino;
    private String Nombre;
    private String Edad;
    private String Ocupacion;
    private String Salario;
    private String NumMascotas;
    private String Contacto;

    public int getIdInquilino() {
        return idInquilino;
    }
    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEdad() {
        return Edad;
    }
    public void setEdad(String edad) {
        Edad = edad;
    }
    public String getOcupacion() {
        return Ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        Ocupacion = ocupacion;
    }
    public String getSalario() {
        return Salario;
    }
    public void setSalario(String salario) {
        Salario = salario;
    }
    public String getNumMascotas() {
        return NumMascotas;
    }
    public void setNumMascotas(String numMascotas) {
        NumMascotas = numMascotas;
    }
    public String getContactos() {
        return Contacto;
    }
    public void setContactos(String contactos) {
        Contacto = contactos;
    }
    @Override
    public String toString() {
        return "Inquilino [idInquilino=" + idInquilino + ", Nombre=" + Nombre + ", Edad=" + Edad + ", Ocupacion="
                + Ocupacion + ", Salario=" + Salario + ", NumMascotas=" + NumMascotas + ", Contactos=" + Contacto
                + "]";
    }

    

  
}
   