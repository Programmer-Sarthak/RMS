package Sevelet;

import sql_management.sql.connection.CustomerCon;
import sql_management.sql.data_access.CustomerDA;
import Storage.User;
import surplus.Msg;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String username = request.getParameter("Username");
        String password = request.getParameter("password");

        CustomerDA customerDA = new CustomerCon();
        Msg msg = new Msg();

        try {
            User user = customerDA.getCustomer(username);

            if (user.getUser_username() == null) {

                    try {
                        Integer.parseInt(username);
                        msg.setMsg("Check your Phone Number!");
                        response.sendRedirect("CustomerLogin.jsp");
                    } catch (NumberFormatException e) {
                        msg.setMsg("Check your Username!");
                        response.sendRedirect("CustomerLogin.jsp");
                    }

            } else if ((user.getUser_username().equals(username)
                    || user.getPhone().equals(username))) {

                if (user.getUser_password().equals(password)) {

                    HttpSession session = request.getSession();
                    session.setAttribute("id", user.getUser_id());
                    session.setAttribute("fname", user.getUser_firstName());
                    session.setAttribute("lname", user.getUser_lastName());
                    session.setAttribute("uname", user.getUser_username());
                    session.setAttribute("email", user.getEmail());
                    session.setAttribute("phone", user.getPhone());
                    session.setAttribute("role", user.getRole());
                    session.setAttribute("add1", user.getAddress1());
                    session.setAttribute("add2", user.getAddress2());
                    session.setAttribute("role", "Customer");

                    response.sendRedirect("Customer.jsp");

                } else {
                    msg.setMsg("Check your Password!");
                    response.sendRedirect("CustomerLogin.jsp");
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}