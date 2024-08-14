package Sevelet;

import sql_management.sql.connection.CustomerCon;
import sql_management.sql.data_access.CustomerDA;
import Storage.User;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customersignup")
public class CustomerSignUP extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Fname = request.getParameter("Firstname");
        String Lname = request.getParameter("Lastname");
        String Uname = request.getParameter("Username");
        String Pass = request.getParameter("password");
        String Phone = request.getParameter("Phone");
        String Dob = request.getParameter("Dob");
        String Email = request.getParameter("Email");
        String Add1 = request.getParameter("Add1");
        String Add2 = request.getParameter("Add2");

        //converting data
        Date dateOfBirth = Date.valueOf(Dob);

        User user = new User("Customer",Fname,Lname,Uname,dateOfBirth,Pass,Email,Phone,Add1,Add2);

        CustomerDA customerDA = new CustomerCon();

        try {
            int result = customerDA.insertCustomer(user);
            response.sendRedirect("CustomerLogin.jsp?message=Customer SignUP Success");


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n Data insertion failed");
            e.printStackTrace();
        }
    }
}