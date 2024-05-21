package com.basesdedatos.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> findAll() throws SQLException;
    T getById(Integer id) throws SQLException;
    void save(T entity) throws SQLException;
    void delete(Integer id) throws SQLException;
}
