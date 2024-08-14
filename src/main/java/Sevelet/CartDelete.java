package Sevelet;

import sql_management.sql.connection.CartCon;
import sql_management.sql.data_access.CartDA;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartDel")
public class CartDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public CartDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        int uid = Integer.parseInt(request.getParameter("uid"));
        int fid = Integer.parseInt(request.getParameter("fid"));
        String page = request.getParameter("page");

        try {
            CartDA cartDA = new CartCon();

            int result = cartDA.deleteCart(fid, uid);

            response.sendRedirect(page + ".jsp?message=Cart deleted Success");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("\n Data insertion failed");
            e.printStackTrace();
        }
    }

}