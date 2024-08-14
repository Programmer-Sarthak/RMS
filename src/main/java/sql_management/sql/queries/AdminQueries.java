package sql_management.sql.queries;

public class AdminQueries {

    //DDL Queries
    //(Insert New)
    public final static String INSERT_BUTTON = "UPDATE transaction_history \n" +
            "SET status = 'Order Completed' \n" +
            "WHERE transaction_id = ?;";
    //(Update Existing)
    public final static String UPDATE_ADMIN_USERNAME = "UPDATE admin SET userName = ? WHERE id = ?";
    //(Surplus)
    public final static String DELETE_ADMIN = "DELETE FROM admin WHERE id = ?";
    public final static String GET_ADMIN = "SELECT * FROM admin WHERE userName = ?";
    public final static String GET_ALL_ADMIN = "SELECT * FROM admin";

    //, , , , , ,
    public final static String INSERT_FOOD_HISTORY = "INSERT INTO transaction_history(customer_id, food_id, quantity, transaction_date,total_price) VALUES (?,?,?,?,?)";


    public final static String GET_HISTORY = "SELECT c.firstName,c.lastName,f.FoodName,f.Price,ca.quantity,ca.transaction_date,ca.total_price,ca.transaction_id,ca.status\n" +
            "FROM transaction_history ca \n" +
            "JOIN customer c ON ca.customer_id = c.id \n" +
            "JOIN fooditems f ON ca.food_id = f.FoodID\n" +
            ";";

    public final static String GET_HISTORY2 = "SELECT c.firstName,c.lastName,f.FoodName,f.Price,ca.quantity,ca.transaction_date,ca.total_price,ca.transaction_id,ca.status\n" +
            "FROM transaction_history ca \n" +
            "JOIN customer c ON ca.customer_id = c.id \n" +
            "JOIN fooditems f ON ca.food_id = f.FoodID\n" +
            "where customer_id = ?\n" +
            ";";




}
