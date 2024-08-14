<%@ page import="sql_management.sql.data_access.CustomerDA" %>
<%@ page import="sql_management.sql.connection.CustomerCon" %>
<%@ page import="Storage.User" %>
<%@ page import="sql_management.sql.data_access.StaffDA" %>
<%@ page import="sql_management.sql.connection.StaffCon" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="CSS/userPF.css">
</head>

<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");

    String username = (String)session.getAttribute("uname");

    int Id = 0;
    String uname = null;

    String role = (String)session.getAttribute("role");

    if(role == null || !(role.equals("Staff"))) {
        response.sendRedirect("AdminLogin.jsp");
    } else {
        Id = (int)session.getAttribute("id");
        uname = (String)session.getAttribute("uname");
    }
%>

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

<br><br><br>

<div class="profile"><img src="image/profile1-removebg-preview.png" height="100"></div>

<%
    StaffDA staffDA = new StaffCon();
    User user = staffDA.getStaff(uname);
%>

<form action="" method="post"> <h1>Profile</h1>

    <div class="form-group">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" value="<%= user.getUser_firstName()%>" id="firstName" readonly>
    </div>

    <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" value="<%= user.getUser_lastName()%>" id="lastName" readonly>
    </div>

    <div class="form-group">
        <label for="phone">Phone Number:</label>
        <input type="tel" name="phone" value="<%= user.getPhone()%>" id="phone" readonly>
    </div>

    <div class="form-group">
        <label for="username">User Name:</label>
        <input type="text" name="username" value="<%= user.getUser_username()%>" id="username" readonly>
    </div>

    <div class="form-group">
        <label for="dob">Date-Of-Join:</label>
        <input type="text" name="dob" value="<%= user.getUser_doj()%>" id="dob" readonly>
    </div>

    <div class="form-group">
        <label for="email">Email Address:</label>
        <input type="email" name="email" value="<%= user.getEmail()%>" id="email" readonly>
    </div>

    <div class="form-group">
        <label for="email">Salary:</label>
        <input type="email" name="email" value="<%=user.getSalary()%>" id="salary" readonly>
    </div>

</form>

<br><br>

<div class="button-container">
    <a href="LogOut" class="button-link"><button class="button-content">Logout</button></a>
</div>

<br><br><br>

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