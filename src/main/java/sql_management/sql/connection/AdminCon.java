package sql_management.sql.connection;

import Storage.History;
import sql_management.sql.data_access.AdminDA;
import sql_management.sql.queries.AdminQueries;
import sql_management.sql.queries.DefaultQueries;
import Storage.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminCon implements AdminDA {

    Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DefaultQueries.DRIVER);

        Connection con = DriverManager.getConnection(DefaultQueries.DB_URL, DefaultQueries.USERNAME, DefaultQueries.PASSWORD);

        return con;
    }

    public int insertButton(int ID) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.INSERT_BUTTON);

        pStmt.setInt(1, ID);

        return pStmt.executeUpdate();
    }


    @Override
    public int updateAdmin(User user) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.UPDATE_ADMIN_USERNAME);

        pStmt.setString(1,user.getUser_username());
        pStmt.setInt(2,user.getUser_id());

        return pStmt.executeUpdate();
    }

    @Override
    public int deleteAdmin(int adminId) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.DELETE_ADMIN);

        pStmt.setInt(1,adminId);

        return pStmt.executeUpdate();
    }

    @Override
    public int insertFoodHistory(int Cust_id,int Food_id,int Qty,Date date,int price) throws SQLException, ClassNotFoundException {
        //transaction_id, customer_id, food_id, quantity, table_id, transaction_date, total_price

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.INSERT_FOOD_HISTORY);

        pStmt.setInt(1,Cust_id);
        pStmt.setInt(2,Food_id);
        pStmt.setInt(3,Qty);
        pStmt.setDate(4,date);
        pStmt.setInt(5,price);

        return pStmt.executeUpdate();
    }

    @Override
    public User getAdmin(String AdminId) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.GET_ADMIN);

        pStmt.setString(1, AdminId);

        ResultSet rs = pStmt.executeQuery();

        User user = new User();

        if(rs.next()) {
            String uname = rs.getString("userName");
            String pass = rs.getString("password");

            user.setUser_username(uname);
            user.setUser_password(pass);
        }
        return user;
    }

    @Override
    public List<User> getAllAdmin() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.GET_ALL_ADMIN);

        ResultSet rs = pStmt.executeQuery();

        List<User> users = new ArrayList<User>();

        while(rs.next()) {

            int id = rs.getInt("id");
            String uname = rs.getString("userName");

            User user = new User();
            user.setUser_id(id);
            user.setUser_username(uname);
            user.setRole("admin");

            users.add(user);
        }
        return users;
    }

    @Override
    public List<History> getHistory() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.GET_HISTORY);

        ResultSet rs = pStmt.executeQuery();

        List<History> historyList = new ArrayList<History>();

        while(rs.next()) {

            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String foodname = rs.getString("FoodName");
            int quantity = rs.getInt("quantity");
            Date transaction_date  = rs.getDate("transaction_date");
            int total_price  = rs.getInt("total_price");
            int id = rs.getInt("transaction_id");
            String stat = rs.getString("status");

            History history = new History();
            history.setFirsName(fname);
            history.setLastName(lname);
            history.setFoodName(foodname);
            history.setQuantity(quantity);
            history.setTransaction_date(transaction_date);
            history.setTotal_price(total_price);
            history.setId(id);
            history.setStat(stat);

            historyList.add(history);
        }
        return historyList;
    }

    @Override
    public List<History> getHistory(int id) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(AdminQueries.GET_HISTORY2);

        pStmt.setInt(1, id);

        ResultSet rs = pStmt.executeQuery();

        List<History> historyList = new ArrayList<History>();

        while(rs.next()) {

            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String foodname = rs.getString("FoodName");
            int quantity = rs.getInt("quantity");
            Date transaction_date  = rs.getDate("transaction_date");
            int total_price  = rs.getInt("total_price");
            int Id = rs.getInt("transaction_id");
            String stat = rs.getString("status");

            History history = new History();
            history.setFirsName(fname);
            history.setLastName(lname);
            history.setFoodName(foodname);
            history.setQuantity(quantity);
            history.setTransaction_date(transaction_date);
            history.setTotal_price(total_price);
            history.setId(Id);
            history.setStat(stat);

            historyList.add(history);
        }
        return historyList;
    }


}
