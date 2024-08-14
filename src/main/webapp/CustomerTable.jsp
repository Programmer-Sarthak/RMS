<%@ page import="sql_management.sql.data_access.AdminDA" %>
<%@ page import="sql_management.sql.connection.AdminCon" %>
<%@ page import="Storage.History" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sql_management.sql.data_access.StaffDA" %>
<%@ page import="sql_management.sql.connection.StaffCon" %>
<%@ page import="Storage.User" %>
<%@ page import="Storage.TableReservation" %>
<%@ page import="sql_management.sql.data_access.TableReserveDA" %>
<%@ page import="sql_management.sql.connection.TRCon" %>
<%@ page import="sql_management.sql.data_access.FoodDA" %>
<%@ page import="sql_management.sql.connection.FoodCon" %>
<%@ page import="Storage.Food" %>
<!DOCTYPE html>
<html lang="en">

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");

    String role = (String)session.getAttribute("role");
    String req = null;
    int id = 0;

    if(role == null || !(role.equals("Customer"))) {
        response.sendRedirect("CustomerLogin.jsp");
    } else {
        id = (Integer) (session.getAttribute("id"));
        req = (String) (session.getAttribute("req"));
    }
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=req%></title>
    <link rel="stylesheet" href="CSS/staffM.css">
</head>
<body>

    <header>
        <nav>
          <div class="navbar">
            <div class="log"><img src="image/logo.png" height="80"></div>
            <a href="#"><div class="logo">  Guru Kripa<span>.</span></div></a>
            <ul>
              <div class="menu-list"><span id="menu-close-btn" class="material-symbols-outlined">Close <span>X</span></span>
                  <li><a href="HomePage.jsp">Home</a></li>
                  <li><a href="Menu.jsp">Menu</a></li>
                  <li><a href="dining.jsp">Dining</a></li>
                  <li><a href="Cart.jsp">Cart</a></li>
                  <li><a href="CustomerTable?req=reservation">Reservation History</a></li>
                  <li><a href="CustomerTable?req=statement">Order History</a></li>
              </div>
            </ul>
            <span id="menu-btn" class="material-symbols-outlined">&#x2630;</span>
          </div>
        </nav>
      </header>


    <div class="table">
        <table>
            <%
                int count = 0;
                if(req.equals("statement")) {
                    AdminDA adminDA = new AdminCon();

                    List<History> historyList = new ArrayList<>();
                    historyList = adminDA.getHistory(id);
            %>
            <caption>Monthly Statement</caption>
                 <tr>
                     <th>Id</th>
                     <th>Name</th>
                     <th>Food</th>
                     <th>Quantity</th>
                     <th>Price</th>
                     <th>Date</th>
                 </tr>

            <%for(int i = (historyList.size()-1);i>=0;i--) {
                count++;%>

                 <tr>
                     <td><%=count%></td>
                     <td><%=historyList.get(i).getFirsName() + " " + historyList.get(i).getLastName()%></td>
                     <td><%=historyList.get(i).getFoodName()%></td>
                     <td><%=historyList.get(i).getQuantity()%></td>
                     <td><%=historyList.get(i).getTotal_price()%></td>
                     <td><%=historyList.get(i).getTransaction_date()%></td>
                 </tr>

            <%}}else if(req.equals("reservation")) {
                TableReserveDA tableReserveDA = new TRCon();
                    List<TableReservation> TableReservationList = new ArrayList<>();
                    TableReservationList = tableReserveDA.getAllReservation(id);
            %>
            <caption>Table Reservation</caption>
            <tr>
                <th>Account Name</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Table</th>
                <th>Ocassion</th>
                <th>Price</th>
                <th>Date</th>
                <th>Time</th>
            </tr>

            <%for(int i = (TableReservationList.size()-1);i>=0;i--) {;%>

                <%try {%>
            <tr>
                <td><%=TableReservationList.get(i).getFname() + " " + TableReservationList.get(i).getLname()%></td>
                <td><%=TableReservationList.get(i).getName()%></td>
                <td><%=TableReservationList.get(i).getPhone()%></td>
                <td><%=TableReservationList.get(i).getTable_type()%></td>
                <td><%=TableReservationList.get(i).getOccasion_type()%></td>
                <td><%=TableReservationList.get(i).getPrice()%></td>
                <td><%=TableReservationList.get(i).getDate()%></td>
                <td><%=TableReservationList.get(i).getTime()%></td>
            </tr>
                <%} catch (IndexOutOfBoundsException e) {
                    out.print("No History");
                }%>

        <%}}%>
        </table>      
      </div>

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