package data;

import java.sql.SQLException;

public interface BasicRepository<T> {

    T getById(String id) throws SQLException;

    T[] getAll() throws SQLException;
}
