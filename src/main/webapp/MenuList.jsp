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
<%@ page import="java.net.IDN" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");

    String role = (String)session.getAttribute("role");

    int Id = 0;
    String fname = null;

    if(role == null || !(role.equals("Customer"))) {
        response.sendRedirect("CustomerLogin.jsp");
    } else {
        Id = (int)session.getAttribute("id");
        fname = (String) (session.getAttribute("fcateory"));
    }
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= fname%></title>
    <link rel="stylesheet" href="CSS/breakfast.css">
</head>
<body>
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
                    <li><a href="Cart.jsp">Cart</a></li>
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

<div class="menu">
    <div class="heading">
        <h3>&mdash;<%= fname%>&mdash;</h3><br><hr>
    </div>
</div>


    <%
        FoodDA foodDA = new FoodCon();
        CartDA cartDA = new CartCon();


        int count = 0;

        List<Food> foodList = new ArrayList<>();
        foodList = foodDA.getAllFood(fname);

        for(int i=0;i<=((foodList.size() - 1));i++) {

            int CQ = cartDA.getQuantity(Id,foodList.get(i).getFoodID());

            count++;

            if(count == 1) {
%>

<div class="sahi">

    <%}%>

            <div class="food-items">
                <img src="menu_image/<%= foodList.get(i).getFoodID()%>.jpeg" alt="Poha" ><br><hr>
                <div class="details">
                    <h5><%= foodList.get(i).getFoodName()%></h5>
                    <h5 class="price">Price: ₹<%= foodList.get(i).getPrice()%></h5>
                </div>
                <p><%= foodList.get(i).getDescription()%></p><hr><br>

                <div class="quantity">

                    <%
                        if (CQ > 0) {
                            if (CQ == 1) {
                    %>


                    <div>
                        Qty :
                    </div>
                    <a class ="button"  href=CartDel?uid=<%= Id%>&fid=<%= foodList.get(i).getFoodID()%>&page=MenuList><button>-</button></a>
                    <span><%= CQ%></span>
                    <a class ="button"  href=CartInc?uid=<%= Id%>&fid=<%= foodList.get(i).getFoodID()%>&page=MenuList><button>+</button></a>

                    <%} else{%>

                    <div>
                        Qty :
                    </div>
                    <a class ="button"  href=CartDec?uid=<%= Id%>&fid=<%= foodList.get(i).getFoodID()%>&page=MenuList><button>-</button></a>
                    <span><%= CQ%></span>
                    <a class ="button"  href=CartInc?uid=<%= Id%>&fid=<%= foodList.get(i).getFoodID()%>&page=MenuList><button>+</button></a>

                    <%}
                    } else{%>

                    <div>
                        Qty :
                    </div>
                    <a class ="button"><button>-</button></a>
                    <span><%= CQ%></span>
                    <a class ="button"  href=CartInsert?uid=<%= Id%>&fid=<%= foodList.get(i).getFoodID()%>&page=MenuList><button>+</button></a>

                    <%}%>

                </div>
            </div>
        <%
            if(count == 3 || (foodList.size() - 1) == i) {
            count = 0;
        %>
        </div>

    <%}}%>


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