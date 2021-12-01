<%-- 
    Document   : user
    Created on : Jun 1, 2021, 4:49:06 PM
    Author     : Suki
--%>
<%@page import="asm.shopping.ProductDAO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="asm.shopping.Product"%>
<%@page import="asm.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BEARS BookStore</title>
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
        <h1>Welcome ${sessionScope.LOGIN_USER.fullName} to BEARS BookStore</h1>

        

        <form action="MainController" method="POST">
            <input type="submit" name="action" value="View Cart">
            Search Book by Name<input type="text" name="searchProduct" value="${param.searchProduct}"/>
            <input type="submit" name="action" value="Search Product"/>
            <%
                List<Product> list = (List<Product>) request.getAttribute("LIST_PRODUCT");
                if (list == null) {
                    ProductDAO dao = new ProductDAO();
                    list = dao.searchProduct("");
                }
            %>

            <table border="1">
                <thead>
                    <tr>
                        <th>Book Cover</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>price</th>
                        <th>Quantity in Stock</th>
                        <th>create Date</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Product pd : list) {
                    %>
                <form action="MainController">

                    <tr>

                        <td>
                            <input type="text" name="id" style="text-align: center" value="<%= pd.getProductID()%>" readonly=""/>
                        </td>
                        <td>
                            <img src= "<%= pd.getImage()%>" style="width:250px;height:350px;">
                        </td>

                        <td>
                            <input type="text" name="name" style="text-align: center" value="<%= pd.getProductName()%>" readonly=""/>
                        </td>

                        <td>
                            <input type="text" name="des" style="text-align: center" value="<%= pd.getDescription()%>" readonly=""/>
                        </td>

                        <td>
                            <input type="number" name="price" style="text-align: center" value="<%=pd.getPrice()%>" readonly=""/>
                        </td>

                        <td>
                            <input type="number" name="quantity" style="text-align: center" value="<%=pd.getQuantity()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="createDate" style="text-align: center" value="<%=pd.getCreateDate()%>" readonly=""/>
                        </td>

                        <td>
                            <input type="hidden" name="image" value="<%= pd.getImage()%>"  readonly="">
                            <input type="number" name="buynum" value="1" min="1" max="<%=pd.getQuantity()%>"/>
                            <input type="submit" name="action" value="Add to Cart"/>
                        </td>                                           
                    </tr>
                </form>

                <%
                    }
                %>
                </tbody>
            </table>
        </form>
                <jsp:include page="FOOTER.jsp"></jsp:include>
    </body>
</html>
