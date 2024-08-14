package sql_management.sql.connection;

import Storage.Cart;
import Storage.Food;
import surplus.MathLogic;
import sql_management.sql.data_access.CartDA;
import sql_management.sql.queries.CartQueries;
import sql_management.sql.queries.DefaultQueries;
import Storage.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartCon implements CartDA {

    Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DefaultQueries.DRIVER);

        Connection con = DriverManager.getConnection(DefaultQueries.DB_URL, DefaultQueries.USERNAME, DefaultQueries.PASSWORD);

        return con;
    }

    @Override
    public int insertCart(int f, int u) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CartQueries.INSERT_CART);

        pStmt.setInt(1,u);
        pStmt.setInt(2,f);
        pStmt.setInt(3,1);

        return pStmt.executeUpdate();
    }

    @Override
    public int updateCartIncrement(int f, int u) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        User user = new User();
        Food food = new Food();

        PreparedStatement pStmt = con.prepareStatement(CartQueries.UPDATE_CART_INCREMENT);

        pStmt.setInt(1,u);
        pStmt.setInt(2,f);

        return pStmt.executeUpdate();
    }

    public int updateCartDecrement(int f, int u) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        User user = new User();
        Food food = new Food();

        PreparedStatement pStmt = con.prepareStatement(CartQueries.UPDATE_CART_DECREMENT);

        pStmt.setInt(1,u);
        pStmt.setInt(2,f);

        return pStmt.executeUpdate();
    }

    @Override
    public int deleteCart(int f, int u) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CartQueries.DELETE_CART);

        pStmt.setInt(1,u);
        pStmt.setInt(2,f);

        return pStmt.executeUpdate();
    }

    @Override
    public int deleteCart2(int u) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CartQueries.DELETE_CART2);

        pStmt.setInt(1,u);

        return pStmt.executeUpdate();
    }

    @Override
    public int getQuantity(int u,int f) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CartQueries.GET_QUANTITY);

        pStmt.setInt(1,u);
        pStmt.setInt(2,f);

        ResultSet rs = pStmt.executeQuery();

        if(rs.next()) {

            return rs.getInt("quantity");
        }
        return 0;
    }

    @Override
    public List<Cart> getAllCart(int uid) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(CartQueries.CART_DISPLAY);

        pStmt.setInt(1,uid);

        ResultSet rs = pStmt.executeQuery();

        List<Cart> cartList = new ArrayList<Cart>();

        while(rs.next()) {

            int fid = rs.getInt("food_id");
            int cid = rs.getInt("customer_id");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");

            User user = new User();

            Cart cart = new Cart();

            cart.setFood_id(fid);
            cart.setCustomer_id(cid);
            cart.setQuantity(quantity);
            cart.setPrice(price);

            MathLogic mathLogic = new MathLogic();
            mathLogic.totalBill(price,quantity);

            user.setRole("Customer");

            cartList.add(cart);
        }
        return cartList;
    }
}