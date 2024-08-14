<%@ page import="sql_management.sql.data_access.FoodDA" %>
<%@ page import="sql_management.sql.connection.FoodCon" %>
<%@ page import="sql_management.sql.data_access.CartDA" %>
<%@ page import="sql_management.sql.connection.CartCon" %>
<%@ page import="sql_management.sql.data_access.CustomerDA" %>
<%@ page import="sql_management.sql.connection.CustomerCon" %>
<%@ page import="Storage.Food" %>
<%@ page import="Storage.Cart" %>
<%@ page import="sql_management.sql.queries.ImageUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="surplus.MathLogic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="CSS/Cart.css">
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");

    int Id = 0;

    String role = (String)session.getAttribute("role");

    if(role == null || !(role.equals("Customer"))) {
        response.sendRedirect("CustomerLogin.jsp");
    } else {
        Id = (int)session.getAttribute("id");
    }
%>

    <header>
        <nav>
          <div class="navbar">
            <div class="log"><img src="image/logo.png" height="80"></div>
            <a href="#"><div class="logo">  Guru Kripa<span>.</span></div></a>
            <ul>
                <div class="menu-list"><span id="menu-close-btn" class="material-symbols-outlined">Close <span>X</span></span>
                    <li><a href="Customer.jsp">Home</a></li>
                    <li><a href="Menu.jsp">Menu</a></li>
                    <li><a href="dining.jsp">Dining</a></li>
                    <li><a href="">Cart</a></li>
                    <li><a href="Profile.jsp">Profile</a></li>
                    <li><a href="CustomerTable?req=reservation">Reservation History</a></li>
                    <li><a href="CustomerTable?req=statement">Order History</a></li>
                </div>
            </ul>
            <span id="menu-btn" class="material-symbols-outlined">&#x2630;</span>
          </div>
        </nav>
      </header>
      <br>
      <br>
      <br>
      <br>

    <div class="cart-container">
        <h1>Your Cart</h1>
        <hr>
        <br>
        <br>

        <%
            FoodDA foodDA = new FoodCon();
            CartDA cartDA = new CartCon();

            Food food = new Food();
            MathLogic mathLogic = new MathLogic();
            mathLogic.setTotalPrice(0);

            List<Cart> cartList = new ArrayList<>();
            cartList = cartDA.getAllCart(Id);

            for(int i=0;i<=(cartList.size() - 1);i++) {

                food = foodDA.getFood(cartList.get(i).getFood_id());
        %>


        <div class="cart-item">


            <img src="data:image/jpg;base64,<%= ImageUtils.displayImage(food.getImage())%>" alt="">
            <div class="item-details">
                <h2><%= food.getFoodName()%></h2>
                <p><%= food.getDescription()%></p>

                <div class="quantity">

                    <%
                        if (cartList.get(i).getQuantity() > 0) {
                            if (cartList.get(i).getQuantity() == 1) {
                    %>


                    <div>
                        Qty :
                    </div>
                    <a class ="button"  href=CartDel?uid=<%= Id%>&fid=<%= food.getFoodID()%>&page=Cart><button>-</button></a>
                    <span><%= cartList.get(i).getQuantity()%></span>
                    <a class ="button"  href=CartInc?uid=<%= Id%>&fid=<%= food.getFoodID()%>&page=Cart><button>+</button></a>

                    <%} else{%>

                    <div>
                        Qty :
                    </div>
                    <a class ="button"  href=CartDec?uid=<%= Id%>&fid=<%= food.getFoodID()%>&page=Cart><button>-</button></a>
                    <span><%= cartList.get(i).getQuantity()%></span>
                    <a class ="button"  href=CartInc?uid=<%= Id%>&fid=<%= food.getFoodID()%>&page=Cart><button>+</button></a>

                    <%}
                    } else{%>

                    <div>
                        Qty :
                    </div>
                    <a class ="button"><button>-</button></a>
                    <span><%= cartList.get(i).getQuantity()%></span>
                    <a class ="button"  href=CartInsert?uid=<%= Id%>&fid=<%= food.getFoodID()%>&page=Cart><button>+</button></a>

                    <%}%>

                </div>
                <p class="price">₹<%= food.getPrice()%></p>
            </div>
        </div>
        <%}%>


        <div class="summary">
            <p>Subtotal: <span>₹<%= mathLogic.getTotalPrice()%></span></p>
            <%--            <p>GST: <span>₹46</span></p>--%>
            <% int a;
                if(mathLogic.getTotalPrice() == 0) {
                    a = 0;
                } else{
                    a=(mathLogic.getTotalPrice()+30);
            %>
            <p>Delivery Charge: <span>₹30</span></p>
            <%}%>
            <p>Total: <span>₹<%= a%></span></p>
        </div>
        <div class="promo-code">
            <input type="text" placeholder="Enter Promo Code">
            <button>Apply</button>
        </div>
        <div class="cart-buttons">
            <a href="Menu.jsp"><button id="a">Continue Shopping</button></a>
            <a href="Bill?uid=<%= Id%>&rid=cart"><button id="b">Payment</button></a>
        </div>

    </div>

    <br>
      <br>
      <br>
      <br>

    <footer>
        <div class="about">
          <h2>About Guru Kripa</h2> <br><hr> <hr> <br>
        <p>Guru Kripa Restaurant is a family-owned business serving delicious and authentic Indian cuisine for over many years. We use fresh, high-quality ingredients and traditional recipes to create dishes that are bursting with flavor.</p> <br>
        <p>Our warm and inviting atmosphere makes Guru Kripa the perfect place to enjoy a meal with family and friends.</p> <br>
          <h1>Contact Us</h1>
          <p> +91 7723984580 <br>
          shivamgsoni422@gmail.com</p> <br>
        </div>
        <div class="copy">
        <p>Copyright &copy; 2024 Guru Kripa Family Restaurant. All Rights Reserved</p>
      </div>
      </footer>
    
      <script>
        const header = document.querySelector("header");
        const menuBtn = document.querySelector("#menu-btn");
        const menuCloseBtn = document.querySelector("#menu-close-btn");
    
        menuBtn.addEventListener("click" , () => {
          header.classList.toggle("show-mobile-menu");
        });
    
        menuCloseBtn.addEventListener("click" , () => {
          menuBtn.click();
        });
      </script>
</body>
</html>