<%-- 
    Document   : admin
    Created on : Jun 1, 2021, 4:51:52 PM
    Author     : Suki
--%>


<%@page import="asm.user.UserDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="asm.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
        <title>Admin Page</title>
    </head>
    <body>        
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            if (!"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
            if (loginUser != null) {
                String search = (String) request.getParameter("search");
                if (search == null) {
                    search = "";
                }

        %> 

        <h1>ADMIN NAME : <%= loginUser.getFullName()%></h1>
        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <%
            String error_message = (String) request.getAttribute("ERROR_MESSAGE");
            if (error_message != null) {
        %>
        <h1>
            <%=error_message%>
        </h1>
        <%
            }
        %>     
        <form action="MainController">
            Search by Name: <input type="text" name="search" value="<%=search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list == null) {
                    UserDAO dao = new UserDAO();
                    list = dao.getListUser("");
                }
        %>        
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID(AD or US)</th>
                    <th>phone</th>                                
                    <th>Status(AC or IAC)</th>
                    <th>Password</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO dto : list) {
                %> 
                <tr>
            <form action="MainController">
                <td><%= count++%></td>
                <td><%= dto.getUserID()%></td>
                <td>
                    <input type="text" name="fullName" value="<%= dto.getFullName()%>"/>                                    
                </td>
                <td>
                    <input type="text" name="roleID" value="<%= dto.getRoleID()%>"/>
                </td>
                <td>
                    <input type="text" name="phone" value="<%= dto.getPhone()%>"/>
                </td>
                <td>
                    <input type="text" name="statusID" value="<%= dto.getStatusID()%>"/>
                </td>
                <td><%= dto.getPassword()%></td>
                <td>
                    <form action="MainController">
                        <input type="submit" name="action" value="Confirm Update"/>
                        <input type="hidden" name="userID" value="<%=dto.getUserID()%>"/>
                        <input type="hidden" name="search" value="<%= search%>"/>
                    </form>
                </td>
                <td>
                    <% String userDelete = dto.getUserID(); %>
                    <a href="MainController?action=Delete&search=<%=search%>&userID=<%=userDelete%>"><button>Delete</button></a>
                </td>
                </td>
            </form>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<%
        }
%>

</body>
</html>
