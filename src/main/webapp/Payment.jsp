<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Confirmation</title>
    <link rel="stylesheet" href="CSS/Payment.css">
</head>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");

    String role = (String)session.getAttribute("role");

    if(role == null || !(role.equals("Customer"))) {
        response.sendRedirect("CustomerLogin.jsp");
    }
%>

<body>
    <div class="confirmation-container">
        <div class="confirmation-card">
            <div class="checkmark-container">
                <div class="checkmark">&#10003;</div>
            </div>
            <h1>Payment Successful</h1>
            <p>Thank you for your payment!</p>
            <p>Your transaction ID is <strong>#123456789</strong></p>
            <a href="Customer.jsp" class="home-button">Go to Home</a>
        </div>
    </div>
</body>
</html>
