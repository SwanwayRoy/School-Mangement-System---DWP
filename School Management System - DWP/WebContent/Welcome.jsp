<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Welcome</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="design.css" rel="stylesheet" />
</head>
<body>
 <header>
        <img src="logo1.jpg" align="left" width="184px" height="126px" >
        <h2>School Management System</h2>
    </header>
    
     <section>
        <nav>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="form.html">Registration</a></li>
                 <li><a href="DisplayServlet">Display User</a></li>
                <li><a href="#">Contact Us</a></li>

            </ul>
        </nav>
        <h1> Welcome ${param.User_name.split("@")[0]}</h1>
         
         </section>

    <footer>
        <p>Alpha School Management System</p>
    </footer>
</body>
</html>