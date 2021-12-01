<%-- 
    Document   : payCart
    Created on : Jul 8, 2021, 2:01:38 PM
    Author     : Suki
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="asm.shopping.ShoppingCart"%>
<%@page import="asm.shopping.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay Page</title>
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
        <h1>Cart of user: ${sessionScope.LOGIN_USER.fullName} </h1>

        <%
            Date dNow = new Date();
            SimpleDateFormat ft
                    = new SimpleDateFormat("yyyy/MM/dd");          
        %>

        <form action="MainController" method="POST">
            <input type="submit" name="action" value="View Cart">
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Book Cover</th>
                    <th>ID</th>                    
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>total</th>
                </tr>
            </thead>
            <tbody>



                <%
                    ShoppingCart cart = (ShoppingCart) session.getAttribute("CART");
                    int count = 1;
                    double total = 0;
                    for (Item book : cart.getCart().values()) {
                        total += book.getItemPrice() * book.getBuyNum();
                %>

     
                <tr>
                    <td>
                        <%= count++%>
                    </td>
                    <td>   
                        <img src= "<%= book.getImage()%>" style="width:250px;height:350px;">
                    </td>         
                    <td>                        
                        <input type="text" name="id" style="text-align: center" value="<%= book.getID()%>" readonly=""/>                        
                    </td>
                    <td>
                        <input style="text-align: center" value="<%= book.getName()%>" readonly="">
                    </td>
                    <td>
                        <input type="number" name="buynum" style="text-align: center" value="<%= book.getBuyNum()%>" min="1" max="<%=book.getQuantity()%>" readonly="" />
                    </td>                    
                    <td>
                        <input style="text-align: center" value="<%= book.getItemPrice()%>" readonly="" >
                    </td>

                    <td>
                        <input type="number" name="priceitem" style="text-align: center" value="<%= book.getItemPrice() * book.getBuyNum()%>" readonly="">
                    </td>
                </tr>

            
            <%
                }
            %>
        </tbody>
    </table>

    <form action="MainController">
        <h1> Total:
            <input type="number" name="pricecart" style="text-align: center" value= "<%= total%>" readonly="">              
        </h1>

        User:<input type="text" name="userID" style="text-align: center" value="${user.userID}" readonly="" /></br>
        Phone:<input type="number" name="phone" style="text-align: center" value="" required="" /></br>
        Email:<input type="email" name="email" style="text-align: center" value="" required="" /></br>
        Address:<input type="text" name="address" style="text-align: center" value="" required= /></br>   
        Date:<input type="text" name="date" style="text-align: center" value="<%= ft.format(dNow)%>" readonly="" /></br>    
        <input type="hidden" name="statusID" style="text-align: center" value="AC" readonly="" /></br>
        <input type="submit" name="action" value="Pay Cart"/>
    </form>
    <jsp:include page="FOOTER.jsp"></jsp:include>

</body>
</html>
