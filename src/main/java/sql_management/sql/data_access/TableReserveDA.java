package sql_management.sql.data_access;

import Storage.TableReservation;
import Storage.User;

import java.sql.SQLException;
import java.util.List;

public interface TableReserveDA {

    int newReservation(TableReservation t) throws SQLException, ClassNotFoundException;

    int deleteReservation(int custId) throws SQLException, ClassNotFoundException;

    User getReservation(String userName) throws SQLException, ClassNotFoundException;

    List<TableReservation> getAllReservation() throws SQLException, ClassNotFoundException;

    List<TableReservation> getAllReservation(int id) throws SQLException, ClassNotFoundException;
}
