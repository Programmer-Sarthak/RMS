package Sevelet;

import Storage.Cart;
import Storage.Food;
import sql_management.sql.connection.AdminCon;
import sql_management.sql.connection.CartCon;
import sql_management.sql.connection.FoodCon;
import sql_management.sql.data_access.AdminDA;
import sql_management.sql.data_access.CartDA;
import sql_management.sql.data_access.FoodDA;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bill")
public class Bill extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int uid = Integer.parseInt(request.getParameter("uid"));
        String rid = request.getParameter("rid");

        double val;



        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        String d = ft.format(new java.util.Date());
        java.util.Date parsedDate = null;
        try {
            parsedDate = ft.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date sqlDate = new Date(parsedDate.getTime());



        CartDA cartDA = new CartCon();
        FoodDA foodDA = new FoodCon();
        AdminDA adminDA = new AdminCon();

        try {
            List<Cart> cartList = new ArrayList<>();
            cartList = cartDA.getAllCart(uid);

            List<Food> foodList = new ArrayList<>();

            for(int i=0;i<=(cartList.size() - 1);i++) {
                Cart cart = cartList.get(i);
                foodList = foodDA.getFoodIngredirent(cart.getFood_id());

                for(int j=0;j<=(foodList.size() - 1);j++) {
                    Food food = foodDA.getRawMaterial(foodList.get(j).getRawMaterialID());
                    val = food.getQuantityAvailable() - foodList.get(j).getQuantityRequired();
                    foodDA.updateStock(foodList.get(j).getRawMaterialID(),val);
                }
                adminDA.insertFoodHistory(uid,cart.getFood_id(),cart.getQuantity(),sqlDate,cart.getPrice());
            }

            cartDA.deleteCart2(uid);

            response.sendRedirect("Payment.jsp?message=Payment Success");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}