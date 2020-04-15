package data;

import java.sql.SQLException;

public interface BasicRepository<T> {

    T getById(int id) throws SQLException;

    T[] getAll() throws SQLException;
}
