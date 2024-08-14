package Sevelet;

import sql_management.sql.connection.CartCon;
import sql_management.sql.connection.FoodCon;
import sql_management.sql.data_access.CartDA;
import sql_management.sql.data_access.FoodDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updatestock")
public class updateStoc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        double qty = Double.parseDouble(request.getParameter("qty"));

        FoodDA foodDA = new FoodCon();

        try {
            foodDA.updateStock(id,qty);
            response.sendRedirect("Table.jsp?req=stock");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}