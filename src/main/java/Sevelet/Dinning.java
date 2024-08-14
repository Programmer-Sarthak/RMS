package Sevelet;

import Storage.TableReservation;
import sql_management.sql.connection.TRCon;
import sql_management.sql.data_access.TableReserveDA;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dinn")
public class Dinning extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
       // response.getWriter().append("Served at: ").append(request.getContextPath());

        int Ocassion = Integer.parseInt(request.getParameter("occasion"));
        int tableType = Integer.parseInt(request.getParameter("tableType"));
        String name = request.getParameter("fullName");
        String phone = request.getParameter("mobileNumber");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int id = Integer.parseInt(request.getParameter("id"));

        Date dateOfReservation = Date.valueOf(date);

        TableReservation t = new TableReservation(id,name,phone,tableType,Ocassion,dateOfReservation,time);

        TableReserveDA tableReserveDa = new TRCon();

        try {
            tableReserveDa.newReservation(t);
            response.sendRedirect("Payment.jsp");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}