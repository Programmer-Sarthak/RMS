<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="CSS/adminButton.css">
</head>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");

    String role = (String)session.getAttribute("role");

    if(role == null || !(role.equals("Admin"))) {
        response.sendRedirect("AdminLogin.jsp");
    }
%>

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

    <div class="heading">
        <h1>Admin Page</h1><br><hr>
    </div>

    <div class="button-container">
        <a href="Table?req=managestaff" class="button button2">Manage Staff</a>
    </div>
    <div class="button-container">
        <a href="Table?req=manageorder" class="button button1">Manage Order</a>
    </div>
    <div class="button-container">
        <a href="Table?req=reservation" class="button button5">Manage Table Reservation</a>
    </div>
    <div class="button-container">
        <a href="Table?req=stock" class="button button3">Manage Stock</a>
    </div>
    <div class="button-container">
        <a href="Table?req=statement" class="button button4">Monthly Statement</a>
    </div><br>
    <div class="button-container">
        <a href="LogOut" class="button button6">LogOut</a>
    </div><br>


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