package sql_management.sql.queries;

public class CartQueries {

    //DDL Queries
    //(Insert New)
    public final static String INSERT_CART = "INSERT INTO cart(customer_id, food_id, quantity) VALUES (?,?,?)";
    //(Update Existing)
    public final static String UPDATE_CART_INCREMENT = "UPDATE cart SET quantity = quantity + 1 WHERE customer_id = ? and food_id = ?";
    public final static String UPDATE_CART_DECREMENT = "UPDATE cart SET quantity = quantity - 1 WHERE customer_id = ? and food_id = ?";
    //(Surplus)
    public final static String DELETE_CART = "DELETE FROM cart WHERE customer_id = ? and food_id = ?";
    public final static String DELETE_CART2 = "DELETE FROM cart WHERE customer_id = ?";
    public final static String GET_CART = "SELECT f.Price,ca.quantity,ca.food_id FROM cart ca JOIN fooditems f ON ca.food_id = f.FoodID where ca.customer_id = ?";
    public final static String GET_QUANTITY = "SELECT quantity FROM cart WHERE customer_id = ? and food_id = ?";

    public final static String CART_DISPLAY  =
            "SELECT " +
            "c.firstName,c.lastName,f.FoodName,f.Category,f.Price,ca.quantity,ca.food_id,ca.customer_id " +
            "FROM " +
            "cart ca JOIN customer c ON ca.customer_id = c.id " +
            "JOIN " +
            "fooditems f ON ca.food_id = f.FoodID " +
            "where " +
            "c.id = ?";
    public final static String GET_ALL_CART = "SELECT * FROM cart WHERE customer_id = ?";
}
