package Sevelet;

import Storage.User;
import sql_management.sql.connection.AdminCon;
import sql_management.sql.connection.StaffCon;
import sql_management.sql.data_access.AdminDA;
import sql_management.sql.data_access.StaffDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/button")
public class OrderCompleted extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        AdminDA adminDA = new AdminCon();

        String id = request.getParameter("id");
        int Id = Integer.parseInt(id);

        try {
            adminDA.insertButton(Id);
            response.sendRedirect("Table.jsp?req=managestaff");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n Data insertion failed");
            e.printStackTrace();
        }
    }
}