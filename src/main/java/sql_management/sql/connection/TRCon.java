package sql_management.sql.connection;

import Storage.TableReservation;
import sql_management.sql.data_access.TableReserveDA;
import sql_management.sql.queries.CustomerQueries;
import sql_management.sql.queries.DefaultQueries;
import sql_management.sql.queries.ReservationQueries;
import Storage.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TRCon implements TableReserveDA {
    Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DefaultQueries.DRIVER);

        Connection con = DriverManager.getConnection(DefaultQueries.DB_URL, DefaultQueries.USERNAME, DefaultQueries.PASSWORD);

        return con;
    }

    @Override
    public int newReservation(TableReservation t) throws SQLException, ClassNotFoundException {
        
        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(ReservationQueries.NEW_RESERVATION);

//        reservation_id, customer_id, table_id, occasion_id, reservation_time, name, phone

        pStmt.setInt(1, t.getCustomer_id());
        pStmt.setInt(2, t.getTable_id());
        pStmt.setInt(3,t.getOccasion_id());
        pStmt.setDate(4,t.getDate());
        pStmt.setString(5,t.getTime());
        pStmt.setString(6, t.getName());
        pStmt.setString(7, t.getPhone());

        return pStmt.executeUpdate();
    }

    @Override
    public int deleteReservation(int custId) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CustomerQueries.DELETE_CUSTOMER);

        pStmt.setInt(1,custId);

        return pStmt.executeUpdate();
    }

    @Override
    public User getReservation(String userName) throws SQLException, ClassNotFoundException {

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
    public List<TableReservation> getAllReservation() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(ReservationQueries.GET_RESERVATION);

        ResultSet rs = pStmt.executeQuery();

        List<TableReservation> tableReservations = new ArrayList<TableReservation>();

        while(rs.next()) {

            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String phone = rs.getString("phone");
            String name = rs.getString("name");
            Date date  = rs.getDate("date");
            String time = rs.getString("time");
            String table_type = rs.getString("table_type");
            String occasion_type = rs.getString("occasion_type");
            int price = rs.getInt("Price");

            TableReservation tableReservation = new TableReservation();
            tableReservation.setFname(fname);
            tableReservation.setLname(lname);
            tableReservation.setPhone(phone);
            tableReservation.setName(name);
            tableReservation.setDate(date);
            tableReservation.setTime(time);
            tableReservation.setOccasion_type(occasion_type);
            tableReservation.setPrice(price);
            tableReservation.setTable_type(table_type);

            tableReservations.add(tableReservation);
        }
        return tableReservations;
    }

    @Override
    public List<TableReservation> getAllReservation(int id) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(ReservationQueries.GET_RESERVATION2);
        pStmt.setInt(1, id);

        ResultSet rs = pStmt.executeQuery();

        List<TableReservation> tableReservations = new ArrayList<TableReservation>();

        while(rs.next()) {

            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String phone = rs.getString("phone");
            String name = rs.getString("name");
            Date date  = rs.getDate("date");
            String time = rs.getString("time");
            String table_type = rs.getString("table_type");
            String occasion_type = rs.getString("occasion_type");
            int price = rs.getInt("Price");

            TableReservation tableReservation = new TableReservation();
            tableReservation.setFname(fname);
            tableReservation.setLname(lname);
            tableReservation.setPhone(phone);
            tableReservation.setName(name);
            tableReservation.setDate(date);
            tableReservation.setTime(time);
            tableReservation.setOccasion_type(occasion_type);
            tableReservation.setPrice(price);
            tableReservation.setTable_type(table_type);

            tableReservations.add(tableReservation);
        }
        return tableReservations;
    }
}
