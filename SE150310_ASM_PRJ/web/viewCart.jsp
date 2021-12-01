<%-- 
    Document   : viewCart
    Created on : Jul 6, 2021, 1:53:38 PM
    Author     : Suki
--%>

<%@page import="asm.shopping.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="asm.shopping.Product"%>
<%@page import="asm.shopping.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart-BEARS BookStore</title>
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
        <h1>Cart of User: ${sessionScope.LOGIN_USER.fullName}</h1>        

        <%
            ShoppingCart cart = (ShoppingCart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <h1>Your Cart is Empty</h1>
        <%
            
        } else {
        %>     
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Book Cover</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Quantity in Stock</th>
                    <th>Price</th>
                    <th>total</th>
                    <th>Edit</th>
                    <th>Remove</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                
                
                
                <%
                    int count = 1;
                    double total=0;
                    for (Item book : cart.getCart().values()) {
                        total += book.getItemPrice() * book.getBuyNum();
                %>
                
                <form action="MainController" method="POST">
                   
                <tr>
                    <td>
                        <%= count++%>
                    </td>
                    <td>
                        <img src= "<%= book.getImage()%>" style="width:250px;height:350px;">
                    </td>
                    <td>                        
                        <input type="text" name="itemid" style="text-align: center" value="<%= book.getID()%>" readonly=""/>                        
                    </td>
                    <td>
                        <input style="text-align: center" value="<%= book.getName()%>" readonly="" >
                    </td>
                    <td>
                        <input type="number" name="buynum" style="text-align: center" value="<%= book.getBuyNum()%>"required="" min="1" max="<%=book.getQuantity() %>" />                        
                    </td>  
                    <td>
                        <input  style="text-align: center" value="<%= book.getQuantity()%>" readonly="" >
                    </td>
                    <td>
                        <input  style="text-align: center" value="<%= book.getItemPrice()%>" readonly="" >
                    </td>

                    <td>
                        <input  style="text-align: center" value="<%= book.getItemPrice() * book.getBuyNum()%> " readonly="">
                    </td>
                    <td>
                <input type="submit" name="action" value="Edit"/>
                    </td>    
                    <td>
                <input type="submit" name="action" value="Remove"/>
                    </td>
                                   
                </tr>
                
                </form>
            
            <%
                    }
                %>
                           
            </tbody>
        </table>
        <h1> Total: <%= total %></h1>
        <form action="MainController">
            <input type="submit" name="action" value="Pay"/>
        </form>
        <%
            }
        %>        
        
       <jsp:include page="FOOTER.jsp"></jsp:include>
        
        
    </body>
    
    
    
</html>
