package sql_management.sql.connection;

import sql_management.sql.data_access.CustomerDA;
import sql_management.sql.queries.CustomerQueries;
import sql_management.sql.queries.DefaultQueries;
import Storage.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerCon implements CustomerDA {

    Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DefaultQueries.DRIVER);

        Connection con = DriverManager.getConnection(DefaultQueries.DB_URL, DefaultQueries.USERNAME, DefaultQueries.PASSWORD);

        return con;
    }

    @Override
    public void createSchema(String schemaName) throws SQLException, ClassNotFoundException {

        Class.forName(DefaultQueries.DRIVER);

        Connection con = DriverManager.getConnection(DefaultQueries.DB_BASE, DefaultQueries.USERNAME, DefaultQueries.PASSWORD);

        Statement stmt = con.createStatement();

        String createSchema = DefaultQueries.CREATE_SCHEMA  + schemaName;

        stmt.executeUpdate(createSchema);
    }

    @Override
    public void createTable(String tableName, String tableFields) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();

        String createTable = DefaultQueries.CREATE_TABLE  + tableName + tableFields;

        stmt.executeUpdate(createTable);
    }

    @Override
    public int insertCustomer(User user) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CustomerQueries.INSERT_CUSTOMER);

        pStmt.setString(1, user.getRole());
        pStmt.setInt(2,user.getUser_id());
        pStmt.setString(3,user.getUser_firstName());
        pStmt.setString(4,user.getUser_lastName());
        pStmt.setString(5,user.getUser_username());
        pStmt.setString(6,user.getUser_password());
        pStmt.setDate(7,user.getUser_dob());
        pStmt.setString(8,user.getPhone());
        pStmt.setString(9,user.getEmail());
        pStmt.setString(10,user.getAddress1());
        pStmt.setString(11,user.getAddress2());

        return pStmt.executeUpdate();
    }

    @Override
    public int updateCustomer(User user) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CustomerQueries.UPDATE_CUSTOMER_USERNAME);

        pStmt.setString(1,user.getUser_username());
        pStmt.setInt(2,user.getUser_id());

        return pStmt.executeUpdate();
    }

    @Override
    public int deleteCustomer(int custId) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CustomerQueries.DELETE_CUSTOMER);

        pStmt.setInt(1,custId);

        return pStmt.executeUpdate();
    }

    @Override
    public User getCustomer(String userName) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CustomerQueries.GET_CUSTOMER);

        pStmt.setString(1, userName);
        pStmt.setString(2, userName);

        ResultSet rs = pStmt.executeQuery();

        User user = new User();

        if(rs.next()) {

            int id = rs.getInt("id");
            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String uname = rs.getString("userName");
            String pass = rs.getString("password");
            Date dob = rs.getDate("dob");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String add1 = rs.getString("address1");
            String add2 = rs.getString("address2");


            user.setUser_id(id);
            user.setUser_firstName(fname);
            user.setUser_lastName(lname);
            user.setUser_username(uname);
            user.setUser_password(pass);
            user.setUser_dob(dob);
            user.setPhone(phone);
            user.setEmail(email);
            user.setAddress1(add1);
            user.setAddress2(add2);
            user.setRole("Customer");
        }
        return user;
    }

    @Override
    public List<User> getAllCustomer() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CustomerQueries.GET_ALL_CUSTOMER);

        ResultSet rs = pStmt.executeQuery();

        List<User> users = new ArrayList<User>();

        while(rs.next()) {

            int id = rs.getInt("id");
            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String uname = rs.getString("userName");
            Date dob = rs.getDate("dob");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String add1 = rs.getString("address1");
            String add2 = rs.getString("address2");

            User user = new User();
            user.setUser_id(id);
            user.setUser_firstName(fname);
            user.setUser_lastName(lname);
            user.setUser_username(uname);
            user.setUser_dob(dob);
            user.setPhone(phone);
            user.setEmail(email);
            user.setAddress1(add1);
            user.setAddress2(add2);
            user.setRole("Customer");

            users.add(user);
        }
        return users;
    }
}