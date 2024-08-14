package sql_management.sql.connection;

import Storage.Food;
import sql_management.sql.data_access.FoodDA;
import sql_management.sql.queries.DefaultQueries;
import sql_management.sql.queries.FoodQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

public class FoodCon implements FoodDA {

    Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DefaultQueries.DRIVER);

        Connection con = DriverManager.getConnection(DefaultQueries.DB_URL, DefaultQueries.USERNAME, DefaultQueries.PASSWORD);

        return con;
    }

    @Override
    public int insertFood(Food food) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.INSERT_FOOD);

//        FoodID, FoodName, Category, Price, Description
        pStmt.setInt(1,food.getFoodID());
        pStmt.setString(2,food.getFoodName());
        pStmt.setString(3,food.getCategory());
        pStmt.setDouble(4,food.getPrice());
        pStmt.setString(5,food.getDescription());

        return pStmt.executeUpdate();
    }


    @Override
    public int updateStock(int id,double qty) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.UPDATE_STOCK);

        pStmt.setDouble(1,qty);
        pStmt.setInt(2,id);

        return pStmt.executeUpdate();
    }

    @Override
    public int deleteFood(String Food) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.DELETE_FOOD);

        pStmt.setString(1,Food);

        return pStmt.executeUpdate();
    }

    @Override
    public Food getRawMaterial(int id) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.GET_RAWMATERIAL);

        pStmt.setInt(1,id);

        ResultSet rs = pStmt.executeQuery();

        Food food = new Food();

        if(rs.next()) {

            int RawMaterialID = rs.getInt("RawMaterialID");
            int ReorderLevel = rs.getInt("ReorderLevel");
            int QuantityAvailable = rs.getInt("QuantityAvailable");
            String unit = rs.getString("Unit");
            String RawMaterialName = rs.getString("RawMaterialName");

            food.setQuantityAvailable(QuantityAvailable);
            food.setRawMaterialName(RawMaterialName);
            food.setReorderLevel(ReorderLevel);
            food.setRawMaterialID(RawMaterialID);
            food.setUnit(unit);
        }
        return food;
    }

    @Override
    public Food getFood(int Food) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.GET_FOOD);

        pStmt.setInt(1,Food);

        ResultSet rs = pStmt.executeQuery();

        Food food = new Food();

        if(rs.next()) {

            int id = rs.getInt("FoodID");
            String fname = rs.getString("FoodName");
            String fcategory = rs.getString("Category");
            int price = rs.getInt("Price");
            String desc = rs.getString("Description");
            Blob prfileBlob = rs.getBlob("image");
            InputStream image = prfileBlob.getBinaryStream();


            food.setFoodID(id);
            food.setFoodName(fname);
            food.setCategory(fcategory);
            food.setPrice(price);
            food.setDescription(desc);
            food.setImage(image);
        }
        return food;
    }

    public Food getFood2(String Food) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.GET_FOOD2);

        pStmt.setString(1,Food);

        ResultSet rs = pStmt.executeQuery();

        Food food = new Food();

        if(rs.next()) {

            int id = rs.getInt("FoodID");
            String fname = rs.getString("FoodName");
            String fcategory = rs.getString("Category");
            int price = rs.getInt("Price");
            String desc = rs.getString("Description");
            Blob prfileBlob = rs.getBlob("image");
            InputStream image = prfileBlob.getBinaryStream();


            food.setFoodID(id);
            food.setFoodName(fname);
            food.setCategory(fcategory);
            food.setPrice(price);
            food.setDescription(desc);
            food.setImage(image);
        }
        return food;
    }

    @Override
    public List<Food> getAllFood(String Food) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.GET_ALL_FOOD);

        pStmt.setString(1,Food);

        ResultSet rs = pStmt.executeQuery();

        List<Food> foods = new ArrayList<Food>();

        while(rs.next()) {

            int id = rs.getInt("FoodID");
            String fname = rs.getString("FoodName");
            String fcategory = rs.getString("Category");
            int price = rs.getInt("Price");
            String desc = rs.getString("Description");
            Blob prfileBlob = rs.getBlob("image");
            InputStream image = prfileBlob.getBinaryStream();


            Food food = new Food();
            food.setFoodID(id);
            food.setFoodName(fname);
            food.setCategory(fcategory);
            food.setPrice(price);
            food.setDescription(desc);
            food.setImage(image);

            foods.add(food);
        }

        return foods;
    }

    @Override
    public List<Food> getAllRawMaterial(int id) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.GET_ALL_RAWMATERIAL);

        pStmt.setInt(1,id);

        ResultSet rs = pStmt.executeQuery();

        List<Food> foods = new ArrayList<Food>();

        if(rs.next()) {

            int RawMaterialID = rs.getInt("RawMaterialID");
            int ReorderLevel = rs.getInt("ReorderLevel");
            int QuantityAvailable = rs.getInt("QuantityAvailable");
            String unit = rs.getString("Unit");
            String RawMaterialName = rs.getString("RawMaterialName");

            Food food = new Food();
            food.setQuantityAvailable(QuantityAvailable);
            food.setRawMaterialName(RawMaterialName);
            food.setReorderLevel(ReorderLevel);
            food.setRawMaterialID(RawMaterialID);
            food.setUnit(unit);

            foods.add(food);
        }
        return foods;
    }


    @Override
    public List<Food> getFoodIngredirent(int Fid) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        PreparedStatement pStmt = con.prepareStatement(FoodQueries.GET_ALL_INGREDIENTS);

        pStmt.setInt(1,Fid);

        ResultSet rs = pStmt.executeQuery();

        List<Food> foods = new ArrayList<Food>();

        while(rs.next()) {

            int rawId = rs.getInt("RawMaterialID");
            int qReq = rs.getInt("QuantityRequired");


            Food food = new Food();
            food.setRawMaterialID(rawId);
            food.setQuantityRequired(qReq);

            foods.add(food);
        }

        return foods;
    }
}
