package Sevelet;

import Storage.User;
import sql_management.sql.connection.AdminCon;
import sql_management.sql.connection.CustomerCon;
import sql_management.sql.connection.StaffCon;
import sql_management.sql.data_access.AdminDA;
import sql_management.sql.data_access.CustomerDA;
import sql_management.sql.data_access.StaffDA;
import surplus.Msg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adLogin")
public class AdminLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String username = request.getParameter("Username");
        String password = request.getParameter("password");
        String role = request.getParameter("roll");

        AdminDA adminDA = new AdminCon();
        StaffDA staffDA = new StaffCon();
        Msg msg = new Msg();
        HttpSession session = request.getSession();

        if (role.equals("Admin")) {

            try {
                User user = adminDA.getAdmin(username);

                if (user.getUser_username() == null) {

                    msg.setMsg("Check your Admin Username!");
                    session.invalidate();
                    response.sendRedirect("AdminLogin.jsp");

                } else if (user.getUser_username().equals(username)) {

                    if (user.getUser_password().equals(password)) {

                        session.setAttribute("uname", user.getUser_username());
                        session.setAttribute("role", "Admin");
                        response.sendRedirect("Admin.jsp");

                    } else {
                        msg.setMsg("Check your Password!");
                        session.invalidate();
                        response.sendRedirect("AdminLogin.jsp");
                    }
                }

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else if (role.equals("Staff")) {

            try {
                User user = staffDA.getStaff(username);

                if (user.getUser_username() == null) {

                    msg.setMsg("Check your Staff Username!");
                    session.invalidate();
                    response.sendRedirect("AdminLogin.jsp");

                } else if (user.getUser_username().equals(username)) {

                    if (user.getUser_password().equals(password)) {

                        session.setAttribute("id", user.getUser_id());
                        session.setAttribute("fname", user.getUser_firstName());
                        session.setAttribute("lname", user.getUser_lastName());
                        session.setAttribute("uname", user.getUser_username());
                        session.setAttribute("email", user.getEmail());
                        session.setAttribute("phone", user.getPhone());
                        session.setAttribute("role", "Staff");

                        response.sendRedirect("Staff.jsp");

                    } else {
                        msg.setMsg("Check your Password!");
                        session.invalidate();
                        response.sendRedirect("AdminLogin.jsp");
                    }
                }

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}