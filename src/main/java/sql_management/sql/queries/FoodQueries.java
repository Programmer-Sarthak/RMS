package sql_management.sql.queries;

public class FoodQueries {

    //DDL Queries
    //(Insert New)
    public final static String INSERT_FOOD = "INSERT INTO fooditems(FoodID, FoodName, Category, Price, Description) VALUES (?,?,?,?,?)";
    //(Update Existing)
    public final static String UPDATE_STOCK = "UPDATE rawmaterials SET QuantityAvailable = ? WHERE RawMaterialID = ?";
    //(Surplus)
    public final static String DELETE_FOOD = "DELETE FROM fooditems WHERE FoodName = ?";
//    FoodID, FoodName, Category, Price, Description
    public final static String GET_FOOD = "SELECT * FROM fooditems WHERE FoodID = ?";
    public final static String GET_FOOD2 = "SELECT * FROM fooditems WHERE Category = ?";

    public final static String GET_ALL_FOOD = "SELECT * FROM fooditems WHERE Category = ?";

    public final static String GET_ALL_INGREDIENTS = "SELECT * FROM foodingredients WHERE FoodID = ?";



    public final static String GET_RAWMATERIAL = "SELECT RawMaterialID, RawMaterialName, QuantityAvailable, Unit, ReorderLevel, PricePerUnit FROM rawmaterials WHERE RawMaterialID = ?";
    public final static String GET_ALL_RAWMATERIAL = "SELECT * FROM rawmaterials WHERE RawMaterialID = ?";



}
