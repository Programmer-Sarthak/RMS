package sql_management.sql.queries;

public class CustomerQueries {

    //DDL Queries
    //(Insert New)
    public final static String INSERT_CUSTOMER = "INSERT INTO customer(role, id, firstName, lastName, userName, password, dob, phone, email, address1, address2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    //(Update Existing)
    public final static String UPDATE_CUSTOMER_USERNAME = "UPDATE customer SET userName = ? WHERE id = ?";
    //(Surplus)
    public final static String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";
    public final static String GET_CUSTOMER = "SELECT role, id, firstName, lastName, userName, password, dob, phone, email, address1, address2 FROM customer WHERE userName = ? OR phone = ?";
    public final static String GET_CUSTOMER_DETAILS = "SELECT role, id, firstName, lastName, userName, password, dob, phone, email, address1, address2 FROM customer WHERE userName = ?";
    public final static String GET_ALL_CUSTOMER = "SELECT * FROM customer";
}
