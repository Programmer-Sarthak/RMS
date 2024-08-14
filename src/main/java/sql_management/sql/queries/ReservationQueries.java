package sql_management.sql.queries;

public class ReservationQueries {

    public final static String NEW_RESERVATION = "INSERT INTO reservations(customer_id, table_id, occasion_id, date,time, name, phone) VALUES (?,?,?,?,?,?,?)";
    //(Update Existing)
    public final static String GET_RESERVATION = "SELECT c.firstName,c.lastName,table_type,t.Price,o.occasion_type,ca.date,ca.time,ca.name,ca.phone\n" +
            "    from reservations ca\n" +
            "    join customer c on ca.customer_id = c.id\n" +
            "    Join table_types t on ca.table_id = t.table_id\n" +
            "    join occasion_types o on ca.occasion_id = o.occasion_id;";

    public final static String GET_RESERVATION2 = "SELECT c.firstName,c.lastName,table_type,t.Price,o.occasion_type,ca.date,ca.time,ca.name,ca.phone\n" +
            "    from reservations ca\n" +
            "    join customer c on ca.customer_id = c.id\n" +
            "    Join table_types t on ca.table_id = t.table_id\n" +
            "    join occasion_types o on ca.occasion_id = o.occasion_id\n" +
            "    Where customer_id = ?\n" +
            ";";
}
