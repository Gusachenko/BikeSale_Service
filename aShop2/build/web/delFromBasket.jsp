<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="main.Bicycle"%>
<%@page import="main.AllBicycles"%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <jsp:useBean id="list" class="main.ListItemBicycles" scope="session"></jsp:useBean>
    </head>
    <body>
        <%
             
             if ( request.getParameter("id") != null ){
                int id = Integer.parseInt(request.getParameter("id"));
                Bicycle item = AllBicycles.getInstance().getItem(request.getParameter("id"));
                list.deleteItem(item);
             } else {
        %> 
                 list.clear();
                 <c:remove var="list" scope="session"></c:remove>
        <%
             }
             
             
        %>
            
        <jsp:forward page="basket.jsp"/>
    </body>
</html>
