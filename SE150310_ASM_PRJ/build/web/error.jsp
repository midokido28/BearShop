<%-- 
    Document   : error
    Created on : Jun 1, 2021, 4:37:52 PM
    Author     : Suki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
    </head>
    <body>
        <h1>Error: <%= session.getAttribute("ERROR_MESSAGE") %></h1>
        
    </body>
</html>
