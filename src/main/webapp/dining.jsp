<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dinning</title>
  <link rel="stylesheet" href="CSS/dining.css">
</head>
<body>

<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma", "no-cache");

  String role = (String)session.getAttribute("role");
  int id = 0;

  if(role == null || !(role.equals("Customer"))) {
    response.sendRedirect("CustomerLogin.jsp");
  } else {
    id = (Integer) (session.getAttribute("id"));
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
            <li><a href="">Dining</a></li>
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

  <section class="hero">
    <div class="content">
      <h1>Enjoy The <span>Dining</span></h1>
      <h2>Book Your Table Now!</h2>
      <p>Experience the delightful taste of authentic Indian cuisine at Guru Kripa.</p>

      <br>
      <br>

      <div class="container">
        <h1>Reservation Form</h1>
        <br>
        <br>
        <br>

        <form action="Dinn" method="get">

          <label for="full_Name">Full Name:</label>
          <input type="text" id="full_Name" name="fullName" PLACEHOLDER="Full Name">
          <br>
          <br>


          <label for="mobileNumber">Mobile Number:</label>
          <input type="text" id="mobileNumber" name="mobileNumber" PLACEHOLDER="Phone" >
          <br>
          <br>

          <label for="date">Date:</label>
          <input type="date" id="date" name="date" >
          <br>
          <br>

          <label for="time">Time:</label>
          <input type="time" id="time" name="time" >
          <br>
          <br>

          <label for="tabletype">Table Type:</label>
          <select name="tableType" id="tabletype">
            <option value="1">Two Seater (Rs.500)</option>
            <option value="2">Four Seater (Rs.1000)</option>
            <option value="3">Six Seater (Rs.1500)</option>
            <option value="4">Eight Seater (Rs.2000)</option>
            <option value="5">Ten Seater (Rs.2500)</option>
            <option value="6">Group Seating (20) (Rs.5000)</option>
          </select>
          <br>
          <br>

          <label for="occasion">Occasion:</label>
          <select name="occasion" id="occasion">
            <option value="1">Birthday</option>
            <option value="2">Anniversary</option>
            <option value="3">Business Meeting</option>
            <option value="4">Casual Dining</option>
            <option value="5">Family Gathering</option>
            <option value="6">Date Night</option>
            <option value="7">Celebration</option>
            <option value="8">Other</option>
          </select>
          <br>
          <br>
          <input type="hidden" name="id" value="<%=id%>">

          <button type="submit" class="button" value="Submit">Book Now</button>
        </form>
      </div>
    </div>
  </section>

  <br><br><br><br><br><br>

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

    <div class="admin">
      <a href="AdminLogin.jsp"><button>Admin Login</button></a>
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