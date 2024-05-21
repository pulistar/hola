package com.basesdedatos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.basesdedatos.config.DatabaseConnection;
import com.basesdedatos.model.ContratoAlquiler;
import com.basesdedatos.model.Inquilino;
import com.basesdedatos.model.Propiedad;
import com.basesdedatos.model.Propietario;


public class ConsultaContratosAlquiler {
    public List<ContratoAlquiler> listarContratosAlquiler() {
        List<ContratoAlquiler> contratos = new ArrayList<>();
        String sql = "SELECT idContrato, PrecioAlquiler, FormaPago FROM ContratoAlquiler";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ContratoAlquiler contrato = new ContratoAlquiler();
                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setPrecioAlquiler(rs.getDouble("PrecioAlquiler"));
                contrato.setFormaPago(rs.getString("FormaPago"));
                contratos.add(contrato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contratos;
    }

    public List<Inquilino> listarInquilinosMayoresDe30() {
        List<Inquilino> inquilinos = new ArrayList<>();
        String sql = "SELECT * FROM Inquilinos WHERE Edad > 30";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Inquilino inquilino = new Inquilino();
                inquilino.setIdInquilino(rs.getInt("idInquilino"));
                inquilino.setNombre(rs.getString("Nombre"));
                inquilino.setEdad(rs.getString("Edad"));
                inquilino.setOcupacion(rs.getString("Ocupacion"));
                inquilino.setSalario(rs.getString("Salario"));
                inquilino.setNumMascotas(rs.getString("NumMascotas"));
                inquilino.setContactos(rs.getString("Contacto"));
                inquilinos.add(inquilino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inquilinos;
    }



    public List<Propiedad> listarPropiedadesEnBarrio(String nombreBarrio) {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM Propiedades WHERE barrio = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreBarrio);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Propiedad propiedad = new Propiedad();
                    propiedad.setIdPropiedad(rs.getInt("idPropiedad"));
                    propiedad.setNumEstrato(rs.getInt("numEstrato"));
                    propiedad.setBarrio(rs.getString("barrio"));
                    propiedad.setNumHabitaciones(rs.getInt("numHabitaciones"));
                    propiedad.setNumPisos(rs.getInt("numPisos"));
                    propiedad.setAreaDePropiedad(rs.getDouble("AreaDePropiedad"));
                    propiedad.setAntiguedadInmueble(rs.getInt("AntiguedadInmueble"));
                    propiedad.setNumParqueaderos(rs.getInt("NumParqueaderos"));
                    propiedad.setInquilinos(rs.getString("Inquilinos"));
                    propiedad.setPropiedadescol(rs.getString("propiedadescol"));
                    propiedades.add(propiedad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return propiedades;
    }




    public List<Propietario> contarPropiedadesPorPropietario() {
        List<Propietario> resultados = new ArrayList<>();
        String sql = "SELECT idPropietario, Nombre, numPropiedades FROM Propietarios";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Propietario propietario = new Propietario();
                propietario.setIdPropietario(rs.getInt("idPropietario"));
                propietario.setNombre(rs.getString("Nombre"));
                propietario.setNumPropiedades(rs.getInt("numPropiedades"));
                resultados.add(propietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    public List<Propietario> listarPropietariosConContactoYPropiedades() {
        List<Propietario> resultados = new ArrayList<>();
        String sql = "SELECT idPropietario, Nombre, numPropiedades, Contacto FROM Propietarios";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Propietario propietario = new Propietario();
                propietario.setIdPropietario(rs.getInt("idPropietario"));
                propietario.setNombre(rs.getString("Nombre"));
                propietario.setNumPropiedades(rs.getInt("numPropiedades"));
                propietario.setContacto(rs.getString("Contacto"));
                resultados.add(propietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }



    public List<Propiedad> listarPropiedadesConMasDeTresHabitaciones() {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM Propiedades WHERE numHabitaciones > 3";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Propiedad propiedad = new Propiedad();
                propiedad.setIdPropiedad(rs.getInt("idPropiedad"));
                propiedad.setBarrio(rs.getString("barrio"));
                propiedad.setNumHabitaciones(rs.getInt("numHabitaciones"));
              
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return propiedades;
    }


    public List<Inquilino> listarInquilinosConMascotas() {
        List<Inquilino> inquilinos = new ArrayList<>();
        String sql = "SELECT * FROM inquilinos WHERE NumMascotas > 0";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Inquilino inquilino = new Inquilino();
                inquilino.setIdInquilino(rs.getInt("idInquilino"));
                inquilino.setNombre(rs.getString("Nombre"));
                inquilino.setEdad(rs.getString("Edad"));
                inquilino.setOcupacion(rs.getString("Ocupacion"));
                inquilino.setSalario(rs.getString("Salario"));
                inquilino.setNumMascotas(rs.getString("NumMascotas"));
                inquilino.setContactos(rs.getString("Contacto"));

                inquilinos.add(inquilino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inquilinos;
    }


    public List<Propiedad> listarPropiedadesPorPisosYArea() {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT idPropiedad, numPisos, AreaDePropiedad FROM Propiedades ORDER BY numPisos, AreaDePropiedad";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Propiedad propiedad = new Propiedad();
                propiedad.setIdPropiedad(rs.getInt("idPropiedad"));
                propiedad.setNumPisos(rs.getInt("numPisos"));
                propiedad.setAreaDePropiedad(rs.getDouble("AreaDePropiedad"));

                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return propiedades;
    }



   





    public static void main(String[] args) {
        ConsultaContratosAlquiler consulta = new ConsultaContratosAlquiler();
        List<ContratoAlquiler> contratos = consulta.listarContratosAlquiler();

        
        for (ContratoAlquiler contrato : contratos) {
            System.out.println("ID de Contrato: " + contrato.getIdContrato() +
                               ", Precio de Alquiler: " + contrato.getPrecioAlquiler() +
                               ", Forma de Pago: " + contrato.getFormaPago());
        }
    }
}
