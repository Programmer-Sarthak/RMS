package sql_management.sql.connection;

import sql_management.sql.data_access.StaffDA;
import sql_management.sql.queries.DefaultQueries;
import sql_management.sql.queries.StaffQueries;
import Storage.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffCon implements StaffDA {

    Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DefaultQueries.DRIVER);

        Connection con = DriverManager.getConnection(DefaultQueries.DB_URL, DefaultQueries.USERNAME, DefaultQueries.PASSWORD);

        return con;
    }

    @Override
    public int insertStaff(User user) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(StaffQueries.INSERT_STAFF);

        pStmt.setString(1,user.getRole());

        pStmt.setString(2,user.getSubRole());
        pStmt.setString(3,user.getUser_firstName());
        pStmt.setString(4,user.getUser_lastName());
        pStmt.setString(5,user.getUser_username());
        pStmt.setString(6,user.getUser_password());
        pStmt.setDate(7,user.getUser_doj());
        pStmt.setString(8,user.getPhone());
        pStmt.setString(9,user.getEmail());
        pStmt.setDouble(10,user.getSalary());

        return pStmt.executeUpdate();
    }


    @Override
    public int updateStaff(User user) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(StaffQueries.UPDATE_STAFF_USERNAME);

        pStmt.setString(1,user.getUser_firstName());
        pStmt.setString(2,user.getUser_lastName());
        pStmt.setString(3,user.getUser_username());
        pStmt.setString(4,user.getPhone());
        pStmt.setString(5,user.getEmail());
        pStmt.setDouble(6,user.getSalary());
        pStmt.setInt(7,user.getUser_id());

        return pStmt.executeUpdate();
    }

    @Override
    public int deleteStaff(int id) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(StaffQueries.DELETE_STAFF);

        pStmt.setInt(1,id);

        return pStmt.executeUpdate();
    }

    @Override
    public User getStaff(String staffUsername) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(StaffQueries.GET_STAFF);

        pStmt.setString(1, staffUsername);

        ResultSet rs = pStmt.executeQuery();

        User user = new User();

        if(rs.next()) {

            String uname = rs.getString("userName");
            String pass = rs.getString("password");
            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            Date doj = rs.getDate("doj");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            Double salary = rs.getDouble("salary");
            int Id = rs.getInt("id");

            user.setUser_username(uname);
            user.setUser_firstName(fname);
            user.setUser_lastName(lname);
            user.setEmail(email);
            user.setPhone(phone);
            user.setUser_doj(doj);
            user.setUser_password(pass);
            user.setSalary(salary);
            user.setUser_id(Id);
        }
        return user;
    }

    @Override
    public List<User> getAllStaff() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(StaffQueries.GET_ALL_STAFF);

        ResultSet rs = pStmt.executeQuery();

        List<User> users = new ArrayList<User>();

        while(rs.next()) {

            int id = rs.getInt("id");
            String srole = rs.getString("subRole");
            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String uname = rs.getString("userName");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            Double salary = rs.getDouble("salary");
            Date doj = rs.getDate("doj");

            User user = new User();
            user.setUser_id(id);
            user.setSubRole(srole);
            user.setUser_firstName(fname);
            user.setUser_lastName(lname);
            user.setUser_username(uname);
            user.setPhone(phone);
            user.setEmail(email);
            user.setSalary(salary);
            user.setUser_doj(doj);

            users.add(user);
        }
        return users;
    }
}
