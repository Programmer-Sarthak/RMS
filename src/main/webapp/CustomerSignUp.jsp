<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUP</title>
    <link rel="stylesheet" href="CSS/signup.css">
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");

    String roll = (String)session.getAttribute("role");

    if (roll == null) {}

    else if (roll.equals("Customer")) {
        response.sendRedirect("Customer.jsp");
    } else if (roll.equals("Admin")) {
        response.sendRedirect("Admin.jsp");
    } else if (roll.equals("Staff")) {
        response.sendRedirect("Staff.jsp");
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
                    <li><a href="Menu.jsp">Menu</a></li>
                    <li><a href="dining.jsp">Dining</a></li>
                    <li><a href="Cart.jsp">Cart</a></li>
                    <li><a href="CustomerLogin.jsp">Login</a></li>
                    <li><a href="">Sign Up</a></li>
                </div>
            </ul>
            <span id="menu-btn" class="material-symbols-outlined">&#x2630;</span>
          </div>
        </nav>
      </header>

      <br><br><br>

    <div class="wrapped">
        <form action="customersignup" method="get">
            <h1>Sign Up</h1>
            <div class="sahi">
                <div class="input-box">
                    <input type="text" name="Firstname" placeholder="First Name" required>
                </div>
                <div class="input-box">
                    <input type="text" name="Lastname" placeholder="Last Name" required>
                </div>
            </div>
            <div class="sahi">
                <div class="input-box">
                    <input type="text" name="Username" placeholder="Username" required>
                </div>
                <div class="input-box">
                    <input type="text" name="password" placeholder="Password" required>
                </div>
            </div>
            <div class="sahi">
                <div class="input-box">
                    <input type="date" name="Dob" placeholder="DOB" required>
                </div>
                <div class="input-box">
                    <input type="text" name="Phone" placeholder="Phone" required>
                </div>
            </div>
            <div class="sahi">
                <div class="input-box">
                    <input type="text" name="Email" placeholder="Email" required>
                </div>
                <div class="input-box">
                    <input type="text" name="Add1" placeholder="Address 1" required>
                </div>
            </div>
            <div class="sahi">
                <div class="input-box">
                    <input type="text" name="Add2" placeholder="Address 2" required>
                </div>
            </div>
            <button type ="submit" class="btn">Sign Up</button>
            <div class="register-link">
                 <p>Already have an account? <a href="CustomerLogin.jsp">Login</a></p>
            </div>
        </form>
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