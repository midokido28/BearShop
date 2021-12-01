<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="mycss.css" rel="stylesheet" type="text/css"/>

<c:url var="logoutLink" value="MainController">
    <c:param name="action" value="Logout"></c:param>
</c:url>
<header class="top">
    <h1>BEAR BOOK STORE</h1>
    <a href="user.jsp"><button>HOME</button></a>
    <a href="${logoutLink}"><button>Logout</button></a>  
    <img id="imghead" src="https://i0.wp.com/s1.uphinh.org/2021/07/11/smallicon30e6b81d37c45761.jpg" style="width:1500px;height:300px;  " >
    
</header>
