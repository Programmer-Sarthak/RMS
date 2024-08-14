<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="CSS/Menu.css">
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

<div id="menu"><hr>
    <h1 id="section" style="color: white;">Menu</h1><hr><br>

    <br>

    <div class="menu_col">

        <div class="box">
            <div class="image">
                <a href="Menu?fcateory=Breakfast"><img src="menu_image/4.jpeg" alt="Breakfast"></a>
            </div>

            <br>

            <div>
                <a href="Menu?fcateory=Breakfast"><h3>Breakfast</h3></a>
            </div>
        </div>

        <div class="box">
            <div class="image">
                <a href="Menu?fcateory=Starter"><img src="menu_image/2.jpeg" alt="Starter"></a>
            </div>

            <br>

            <div>
                <a href="Menu?fcateory=Starter"><h3>Starter</h3></a>
            </div>
        </div>

        <div class="box">
            <div class="image">
                <a href="Menu?fcateory=Main Course"><img src="menu_image/1.jpeg" alt="Main Course"></a>
            </div>

            <br>

            <div>
                <a href="Menu?fcateory=Main Course"><h3>Main Course</h3></a>
            </div>
        </div>

    </div>

    <div class="menu_col">

        <div class="box">
            <div class="image">
                <a href="Menu?fcateory=Snack"><img src="menu_image/66.jpeg" alt="Snack"></a>
            </div>

            <br><br>

            <div>
                <a href="Menu?fcateory=Snack"><h3>Snack</h3></a>
            </div>
        </div>

        <div class="box">

            <div class="image">
                <a href="Menu?fcateory=Dessert"><img src="menu_image/53.jpeg" alt="Dessert"></a>
            </div>

            <br>

            <div>
                <a href="Menu?fcateory=Dessert"><h3>Dessert</h3></a>
            </div>
        </div>

        <div class="box">
            <div class="image">
                <a href="Menu?fcateory=Side Dish"><img src="menu_image/47.jpeg" alt="Side Dish"></a>
            </div>

            <br>

            <div>
                <a href="Menu?fcateory=Side Dish"><h3>Side Dish</h3></a>
            </div>
        </div>

    </div>

</div>

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