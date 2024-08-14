package sql_management.sql.data_access;

import Storage.User;

import java.sql.SQLException;
import java.util.List;

public interface StaffDA {

    int insertStaff(User user) throws SQLException, ClassNotFoundException;

    int updateStaff(User user) throws SQLException, ClassNotFoundException;

    int deleteStaff(int id) throws SQLException, ClassNotFoundException;

    User getStaff(String staffUsername) throws SQLException, ClassNotFoundException;

    List<User> getAllStaff() throws SQLException, ClassNotFoundException;
}
