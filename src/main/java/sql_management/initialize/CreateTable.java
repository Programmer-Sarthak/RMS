package sql_management.initialize;

import sql_management.sql.data_access.CustomerDA;
import sql_management.sql.connection.CustomerCon;
import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) {

        CustomerDA customerDA = new CustomerCon();

        try {
            customerDA.createTable("admin ","(\n" +
                    " role VARCHAR(5) NOT NULL,\n" +
                    " id INT NOT NULL AUTO_INCREMENT," +
                    " userName VARCHAR(15) NOT NULL,\n" +
                    " password VARCHAR(15) NOT NULL,\n" +
                    " PRIMARY KEY (id))");

//            customerDA.createTable("customer ","(\n" +
//                    " role VARCHAR(8) NOT NULL,\n" +
//                    " id INT NOT NULL AUTO_INCREMENT," +
//                    " firstName VARCHAR(15) NOT NULL,\n" +
//                    " lastName VARCHAR(15) NOT NULL,\n" +
//                    " userName VARCHAR(15) NOT NULL,\n" +
//                    " password VARCHAR(15) NOT NULL,\n" +
//                    " dob DATE NOT NULL,\n" +
//                    " phone VARCHAR(10) NOT NULL,\n" +
//                    " email VARCHAR(35) NOT NULL,\n" +
//                    " address1 LONGTEXT,\n" +
//                    " address2 LONGTEXT,\n" +
//                    " PRIMARY KEY (id))");

//            customerDA.createTable("staff ","(\n" +
//                    " role VARCHAR(5) NOT NULL,\n" +
//                    " id INT NOT NULL AUTO_INCREMENT," +
//                    " subRole VARCHAR(8) NOT NULL,\n" +
//                    " firstName VARCHAR(15) NOT NULL,\n" +
//                    " lastName VARCHAR(15) NOT NULL,\n" +
//                    " userName VARCHAR(15) NOT NULL,\n" +
//                    " password VARCHAR(15) NOT NULL,\n" +
//                    " doj DATE NOT NULL,\n" +
//                    " phone VARCHAR(10) NOT NULL,\n" +
//                    " email VARCHAR(35) NOT NULL,\n" +
//                    " salary DECIMAL(10,2) NOT NULL,\n" +
//                    " PRIMARY KEY (id))");
            System.out.println("Table created Successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Table creation failed");
            e.printStackTrace();
        }
    }
}
