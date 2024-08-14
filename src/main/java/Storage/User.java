package Storage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class User {
    private int user_id;
    private String user_firstName;
    private String user_lastName;
    private String user_username;
    private Date user_dob;
    private String user_password;
    private String role;
    private String subRole;
    private String email;
    private String phone;
    private String address1;
    private String address2;
    private Double salary;
    private Date user_doj;

    public User() {}

    public User(String role,String user_firstName, String user_lastName, String user_username,
                Date user_dob, String user_password, String email, String phone, String address1, String address2) {
        this.role = role;
        this.user_firstName = user_firstName;
        this.user_lastName = user_lastName;
        this.user_username = user_username;
        this.user_dob = user_dob;
        this.user_password = user_password;
        this.email = email;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
    }

    public User(int user_id,String user_firstName, String user_lastName, String user_username, String email, String phone, Double salary) {
        this.user_firstName = user_firstName;
        this.user_lastName = user_lastName;
        this.user_username = user_username;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.user_id = user_id;
    }

    public User(String user_firstName, String user_lastName, String user_username, String user_password, String role, String subRole, String email, String phone, Double salary, Date user_doj) {
        this.user_firstName = user_firstName;
        this.user_lastName = user_lastName;
        this.user_username = user_username;
        this.user_password = user_password;
        this.role = role;
        this.subRole = subRole;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.user_doj = user_doj;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getSubRole() {
        return subRole;
    }

    public void setSubRole(String subRole) {
        this.subRole = subRole;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_firstName() {
        return user_firstName;
    }

    public void setUser_firstName(String user_firstName) {
        this.user_firstName = user_firstName;
    }

    public String getUser_lastName() {
        return user_lastName;
    }

    public void setUser_lastName(String user_lastName) {
        this.user_lastName = user_lastName;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public Date getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(Date user_dob) {
        this.user_dob = user_dob;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Date getUser_doj() {
        return user_doj;
    }

    public void setUser_doj(Date user_doj) {
        this.user_doj = user_doj;
    }

    public void dateSetter(String date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        java.util.Date utilDate = null;

        while (utilDate == null) {
            try {
                utilDate = dateFormatter.parse(date);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                setUser_dob(sqlDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
    }

    @Override
    public String toString() {
        if(role.equals("Customer")) {
            return "Customer Details {" +
                    "First Name = '" + user_firstName + '\'' +
                    ", Last Name = '" + user_lastName + '\'' +
                    ", Username = '" + user_username + '\'' +
                    ", DOB = " + user_dob +
                    ", E-mail = '" + email + '\'' +
                    ", Phone = '" + phone + '\'' +
                    ", Address 1 = '" + address1 + '\'' +
                    ", Address 2 = '" + address2 + '\'' +
                    '}' + "\n";
        } else if(role.equals("staff")) {
            return "Staff Details {" +
                    "Staff Id  = " + user_id +
                    " Account Type = '" + role + '\'' +
                    ", First Name = '" + user_firstName + '\'' +
                    ", Last Name = '" + user_lastName + '\'' +
                    ", Username = '" + user_username + '\'' +
                    ", DOB = " + user_dob +
                    ", E-mail = '" + email + '\'' +
                    ", Phone = '" + phone + '\'' +
                    '}' + "\n";
        } else if(role.equals("admin")) {
            return "Admin Details {" +
                    "Admin Id  = " + user_id +
                    ", Account Type = '" + role + '\'' +
                    ", Username = '" + user_username + '\'' +
                    '}' + "\n";
        }
        return "";
    }
}
