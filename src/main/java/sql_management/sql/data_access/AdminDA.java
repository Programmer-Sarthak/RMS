package sql_management.sql.data_access;

import Storage.History;
import Storage.TableReservation;
import Storage.User;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface AdminDA {

    int insertButton(int Id) throws SQLException, ClassNotFoundException;

    int updateAdmin(User user) throws SQLException, ClassNotFoundException;

    int deleteAdmin(int adminId) throws SQLException, ClassNotFoundException;


    int insertFoodHistory(int Cust_id, int Food_id, int Qty, Date date, int price) throws SQLException, ClassNotFoundException;

    User getAdmin(String AdminId) throws SQLException, ClassNotFoundException;

    List<User> getAllAdmin() throws SQLException, ClassNotFoundException;

    List<History> getHistory() throws SQLException, ClassNotFoundException;

    List<History> getHistory(int id) throws SQLException, ClassNotFoundException;
}
