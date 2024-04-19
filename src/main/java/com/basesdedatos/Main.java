package com.basesdedatos;

import java.sql.Connection;
import java.sql.SQLException;

import com.basesdedatos.config.DatabaseConnection;
import com.basesdedatos.model.Actor;
import com.basesdedatos.repository.ActorRepository;
import com.basesdedatos.repository.Repository;

public class Main {
    public static void main(String[] args)throws SQLException {
      
        try (Connection myConnection = DatabaseConnection.getInstance()){
            
            Repository<Actor> repository = new ActorRepository();
            System.out.println("--- Listando -----");
           // repository.findAll().forEach(System.out::println);

           System.out.println(repository.getById(1));


           Actor actor = new Actor();
           actor.setFirst_name("prueba 1");
           actor.setLast_name("prueba 2");
           repository.save(actor);

           System.out.println("--- Listando despues de guardar -----");
           repository.findAll().forEach(System.out::println);

            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error conectando");
        }

    }
}