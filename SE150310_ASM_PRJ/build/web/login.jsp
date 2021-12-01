<%-- 
    Document   : login
    Created on : Jul 11, 2021, 7:53:39 PM
    Author     : Suki
--%>

<!DOCTYPE html>

<html>
    <head>
        <title>LOGIN</title>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
                              
        <c:if test="${user.roleID=='US'}">
            <c:redirect url="user.jsp"/>
        </c:if>
        <c:if test="${user.roleID=='AD'}">
            <c:redirect url="admin.jsp"/>
        </c:if>
        
        <header class="top">
            <h1>BEAR BOOK STORE</h1>
            <img id="imghead" src="https://i0.wp.com/s1.uphinh.org/2021/07/11/smallicon30e6b81d37c45761.jpg" style="width:1500px;height:300px;" >
        </header>     
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID"/><br>
            Password <input type="password" name="password"/><br>

            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <a href="createUser.jsp"><button>Create user</button></a>

        <footer>
            <p>Address: BearBookStore - 28/1/20 đường ABCD - Q.Thủ Đức - Tp Hồ Chí Minh</p>
            <p>Phone: 0976622886</p>
            <p>Email: bearbookstore@gmail.com</p>
            <img id="imgfoot" src="https://i0.wp.com/s1.uphinh.org/2021/07/08/LOGO.jpg" style="width:200px;height:200px;"  >
        </footer>
    </body>
</html>

