<%-- 
    Document   : paysuccess
    Created on : Jul 9, 2021, 7:58:30 PM
    Author     : Suki
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BearBookStore</title>
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
        <c:if test="${user==null}">
            <c:redirect url="login.jsp"/>
        </c:if>                       
        <c:if test="${user.roleID!='US'}">
            <c:redirect url="login.jsp"/>
        </c:if>
                  
        <jsp:include page="HEADER.jsp"></jsp:include>
            <h1>Đã Thanh Toán Thành Công</h1>
        <jsp:include page="FOOTER.jsp"></jsp:include>
    </body>
</html>
