package sql_management.sql.data_access;

import Storage.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDA {


    int insertFood(Food food) throws SQLException, ClassNotFoundException;

    int updateStock(int id,double qty) throws SQLException, ClassNotFoundException;

    int deleteFood(String Food) throws SQLException, ClassNotFoundException;
    Food getRawMaterial(int id) throws SQLException, ClassNotFoundException;

    Food getFood(int Food) throws SQLException, ClassNotFoundException;
    Food getFood2(String Food) throws SQLException, ClassNotFoundException;

    List<Food> getAllFood(String Food) throws SQLException, ClassNotFoundException;

    List<Food> getAllRawMaterial(int id) throws SQLException, ClassNotFoundException;

    List<Food> getFoodIngredirent(int Fid) throws SQLException, ClassNotFoundException;
}
