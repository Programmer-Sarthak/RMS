package sql_management.sql.queries;

public class StaffQueries {

    //DDL Queries
    //(Insert New)
    public final static String INSERT_STAFF = "INSERT INTO staff(role, subRole, firstName, lastName, userName, password, doj, phone, email, salary) VALUES (?,?,?,?,?,?,?,?,?,?)";
    //(Update Existing)
    public final static String UPDATE_STAFF_USERNAME = "UPDATE staff SET firstName = ? ,lastName = ?,userName = ?,phone = ?,email = ?,salary = ? WHERE id = ?";
    //(Surplus)
    public final static String DELETE_STAFF = "DELETE FROM staff WHERE id = ?";
    public final static String GET_STAFF = "SELECT * FROM staff WHERE userName = ?";
    public final static String GET_ALL_STAFF = "SELECT * FROM staff";
}
