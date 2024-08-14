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

    if(role == null || (!(role.equals("Admin")) && !(role.equals("Staff")))) {
        response.sendRedirect("AdminLogin.jsp");
    } else {
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
              </div>
            </ul>
            <span id="menu-btn" class="material-symbols-outlined">&#x2630;</span>
          </div>
        </nav>
      </header>


    <div class="table">
        <table>

            <% int count = 0;
                if(req.equals("reservation")) {
                TableReserveDA tableReserveDA = new TRCon();
                    List<TableReservation> TableReservationList = new ArrayList<>();
                    TableReservationList = tableReserveDA.getAllReservation();
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


            <%
                }}else if(req.equals("manageorder")) {
                    AdminDA adminDA = new AdminCon();

                    List<History> historyList = new ArrayList<>();
                    historyList = adminDA.getHistory();
            %>
                <caption>Manage Order</caption>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Food</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>

                    <%
                        for(int i = (historyList.size()-1);i>=0;i--) {
                            count++;
                    %>

                <tr>
                    <td><%=count%></td>
                    <td><%=historyList.get(i).getFirsName() + " " + historyList.get(i).getLastName()%></td>
                    <td><%=historyList.get(i).getFoodName()%></td>
                    <td><%=historyList.get(i).getQuantity()%></td>
                    <td><%=historyList.get(i).getTotal_price()%></td>
                    <td><%=historyList.get(i).getTransaction_date()%></td>
                    <td>
                        <%if(historyList.get(i).getStat() == null){%>
                        <a id = "update2" href = "button?id=<%=historyList.get(i).getId()%>">Done</a>
                        <%}else {%>
                        <button id="update3">Order Completed</button>
                        <%}%>
                    </td>
                </tr>


        <%}} else if(req.equals("stock")) {
            FoodDA foodDA = new FoodCon();
        %>
            <caption>Manage Stock</caption>
            <tr>
                <th>Id</th>
                <th>Raw Material</th>
                <th>Qty. (in stock)</th>
                <th>Message</th>
                <th>Status</th>
            </tr>
        <%
            for(int i=1;i<=31;i++) {
                Food food = foodDA.getRawMaterial(i);
        %>

            <tr>
                <td><%=food.getRawMaterialID()%></td>
                <td><%=food.getRawMaterialName()%></td>
                <td><%=food.getQuantityAvailable() + " " + food.getUnit()%></td>
                <td>
                    <%
                        if(food.getQuantityAvailable()<=food.getReorderLevel()){
                            out.print("LOW STOCK REORDER NOW!!");
                        }else {
                            out.print("ENOUGH STOCK");
                        }
                    %>
                </td>
                <td>
                    <%
                        if(food.getQuantityAvailable()<=food.getReorderLevel()){
                    %>
                    <a href="updatestock?id=<%=food.getRawMaterialID()%>&qty=<%=food.getQuantityAvailable()+10%>"><button id="delete1">Update Stock (+10
                        <%=food.getUnit()%>
                        )</button></a>
                    <%}else {%>
                    <a href="updatestock?id=<%=food.getRawMaterialID()%>&qty=<%=food.getQuantityAvailable()+10%>"><button id="update4">Update Stock (+10
                        <%=food.getUnit()%>
                        )</button></a>
                    <%}%>
                </td>
            </tr>
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