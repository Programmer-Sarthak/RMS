package Sevelet;

import Storage.User;
import sql_management.sql.connection.CustomerCon;
import sql_management.sql.connection.StaffCon;
import sql_management.sql.data_access.CustomerDA;
import sql_management.sql.data_access.StaffDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/staffsignup")
public class StaffSignUP extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String Fname = request.getParameter("Firstname");
        String Lname = request.getParameter("Lastname");
        String Uname = request.getParameter("Username");
        String Pass = request.getParameter("password");
        String Phone = request.getParameter("Phone");
        String Doj = request.getParameter("Doj");
        String Email = request.getParameter("Email");
        String salary = request.getParameter("salary");
        String subrole = request.getParameter("subrole");
        String role = "Staff";

        //converting data
        Date dateOfJoin = Date.valueOf(Doj);
        Double Salary = Double.valueOf(salary);

        User user = new User(Fname,Lname,Uname,Pass,role,subrole,Email,Phone,Salary,dateOfJoin);

        StaffDA staffDA = new StaffCon();

        try {
            int result = staffDA.insertStaff(user);
            response.sendRedirect("Table.jsp?req=managestaff");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n Data insertion failed");
            e.printStackTrace();
        }
    }
}