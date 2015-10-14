<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="main.Bicycle"%>
<%@page import="main.AllBicycles"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add</title>
        <jsp:useBean id="list" class="main.ListItemBicycles" scope="session"></jsp:useBean>
    </head>
    <body>
        <jsp:include page="jheader.jsp"/>
        <%
        
             Bicycle item = AllBicycles.getInstance().getItem(request.getParameter("id"));
             if (item != null) {
                 list.add(item);
                 %><img alt="" src="img/langico/checkmark.png" style="width: 50px; height: 50px;" /><%
             } else {
                 %><img alt="" src="img/langico/trashcan.png" style="width: 50px; height: 50px;" /><%
             }
        %>
        <c:choose>
          <c:when test="${empty param.page}">
             <c:redirect url="Lshop?&iter=${param.id}&addItem=true"/>                  
          </c:when>                    
       </c:choose>
        
    </body>
</html>
