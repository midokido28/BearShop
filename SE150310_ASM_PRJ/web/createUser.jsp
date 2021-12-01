<%-- 
    Document   : createUser
    Created on : Jun 10, 2021, 2:20:29 PM
    Author     : Suki
--%>

<%@page import="asm.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="USER_ERROR" class="asm.user.UserError"></jsp:useBean>
            <header class="top">
                <h1>Create A Bear's Account!</h1>     
            </header>


            <form action="MainController" method="POST">
                User ID <input type="text" name="userID" required=""/>           
            ${requestScope.USER_ERROR.getUserIDError()}</br> 

            Full Name <input type="text" name="fullName" required=""/>            
            ${requestScope.USER_ERROR.getFullNameError()}</br>  

            Phone <input type="number" name="phone" required=""/>
            ${requestScope.USER_ERROR.getPhoneError()}</br>

            Password <input type="password" name="password" required=""/>            
            ${requestScope.USER_ERROR.passwordError}</br>

            Confirm <input type="password" name="confirm" required=""/>            
            ${requestScope.USER_ERROR.confirmPasswordError}</br>

            <input type="hidden" name="roleID" value="US" readonly="">
            <input type="hidden" name="statusID" value="AC" readonly="">
            <input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>            
        </form>  
        <a href="login.jsp"><button>BACK TO LOGIN</button></a>
        <jsp:include page="FOOTER.jsp"></jsp:include>
    </body>
</html>
