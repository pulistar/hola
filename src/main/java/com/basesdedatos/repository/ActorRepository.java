package com.basesdedatos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.basesdedatos.config.DatabaseConnection;
import com.basesdedatos.model.Actor;

public class ActorRepository implements Repository<Actor> {

    private Connection geConnection()throws SQLException{
        return DatabaseConnection.getInstance();
    }
    @Override
    public List<Actor> findAll() throws SQLException {
        List<Actor> actors = new ArrayList<>();
        String sql = "Select * from actor";
        try(Statement myStat = geConnection().createStatement())
        {
            ResultSet myResultSet = myStat.executeQuery(sql);
            while (myResultSet.next()) {
                Actor actor = createActor(myResultSet);
                actors.add(actor);
            }
        } 
        
        return actors;
    }

    @Override
    public Actor getById(Integer id) throws SQLException {
        Actor actor = null;
        String sql  = "Select * from actor where actor_id = ?";
        try(PreparedStatement myStat = geConnection().prepareStatement(sql)){
            myStat.setInt(1, id);
            try(ResultSet myRes = myStat.executeQuery()){
                if(myRes.next()){   
                    actor = createActor(myRes);
                }
            }
        }
        return actor;
    }

    @Override
    public void save(Actor actor) throws SQLException {
        String sql = "INSERT INTO actor (first_name, last_name) values(?,?)";
        try(PreparedStatement myStat = geConnection().prepareStatement(sql)){
            myStat.setString(1, actor.getFirst_name());
            myStat.setString(2, actor.getLast_name());
            myStat.executeUpdate();
        }
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private Actor createActor(ResultSet myResult)throws SQLException{
        Actor actor = new Actor();
        actor.setActor_id(myResult.getInt("actor_id"));
        actor.setFirst_name(myResult.getString("first_name"));
        actor.setLast_name(myResult.getString("last_name"));
        return actor;
    }
    
}
