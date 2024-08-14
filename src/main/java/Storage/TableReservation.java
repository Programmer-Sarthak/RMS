package Storage;

import java.sql.Date;

public class TableReservation {

    private String Fname;
    private String Lname;
    private String name;
    private String phone;
    private int customer_id;
    private int table_id;
    private int occasion_id;
    private String occasion_type;
    private String table_type;
    private Date date;
    private String time;
    private int price;

    public TableReservation() {
    }

    public TableReservation(int customer_id,String name, String phone, int table_id,
                            int occasion_id, Date date, String time) {
        this.name = name;
        this.phone = phone;
        this.table_id = table_id;
        this.occasion_id = occasion_id;
        this.date = date;
        this.time = time;
        this.customer_id = customer_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getOccasion_id() {
        return occasion_id;
    }

    public void setOccasion_id(int occasion_id) {
        this.occasion_id = occasion_id;
    }

    public String getOccasion_type() {
        return occasion_type;
    }

    public void setOccasion_type(String occasion_type) {
        this.occasion_type = occasion_type;
    }

    public String getTable_type() {
        return table_type;
    }

    public void setTable_type(String table_type) {
        this.table_type = table_type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
