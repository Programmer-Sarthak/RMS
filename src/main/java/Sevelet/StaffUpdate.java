package Sevelet;

import Storage.User;
import sql_management.sql.connection.StaffCon;
import sql_management.sql.data_access.StaffDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/staffupdate")
public class StaffUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        StaffDA staffDA = new StaffCon();

        String Fname = request.getParameter("Firstname");
        String Lname = request.getParameter("Lastname");
        String Uname = request.getParameter("Username");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        String salary = request.getParameter("salary");
        String id = request.getParameter("sId");

        //converting data
        Double Salary = Double.valueOf(salary);
        int ID = Integer.parseInt(id);

        User user = new User(ID,Fname,Lname,Uname,Email,Phone,Salary);

        try {
            staffDA.updateStaff(user);
            response.sendRedirect("Table.jsp?req=managestaff");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n Data insertion failed");
            e.printStackTrace();
        }
    }
}