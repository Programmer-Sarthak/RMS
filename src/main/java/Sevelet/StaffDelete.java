package Sevelet;

import sql_management.sql.connection.CartCon;
import sql_management.sql.connection.StaffCon;
import sql_management.sql.data_access.CartDA;
import sql_management.sql.data_access.StaffDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/staffdel")
public class StaffDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public StaffDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        int sId = Integer.parseInt(request.getParameter("sId"));

        try {
            StaffDA staffDA = new StaffCon();

            staffDA.deleteStaff(sId);

            response.sendRedirect("Table.jsp?req=managestaff");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n Data insertion failed");
            e.printStackTrace();
        }
    }

}