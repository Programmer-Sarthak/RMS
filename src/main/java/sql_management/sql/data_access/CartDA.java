package sql_management.sql.data_access;

import Storage.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDA {

    int insertCart(int f, int u) throws SQLException, ClassNotFoundException;

    int updateCartIncrement(int f, int u) throws SQLException, ClassNotFoundException;
    int updateCartDecrement(int f, int u) throws SQLException, ClassNotFoundException;
    int deleteCart(int f, int u) throws SQLException, ClassNotFoundException;
    int deleteCart2(int u) throws SQLException, ClassNotFoundException;
//    void diplayCart(int u) throws SQLException, ClassNotFoundException;
    int getQuantity(int u,int f) throws SQLException, ClassNotFoundException;
    List<Cart> getAllCart(int uid) throws SQLException, ClassNotFoundException;
}
