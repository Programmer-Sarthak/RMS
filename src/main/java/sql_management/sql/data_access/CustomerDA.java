package sql_management.sql.data_access;

import Storage.User;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDA {

    void createSchema(String schemeName) throws SQLException, ClassNotFoundException;

    void createTable(String tableName, String tableFields) throws SQLException, ClassNotFoundException;

    int insertCustomer(User user) throws SQLException, ClassNotFoundException;

    int updateCustomer(User user) throws SQLException, ClassNotFoundException;

    int deleteCustomer(int custId) throws SQLException, ClassNotFoundException;

    User getCustomer(String userName) throws SQLException, ClassNotFoundException;

    List<User> getAllCustomer() throws SQLException, ClassNotFoundException;
}
