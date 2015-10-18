
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>

<%@page import="dbase.WorkingBas"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="main.ListItemBicycles"%>

<c:set var="shopValue_" value="${sessionScope.shopSession}"/>
<c:set var="userName_" value="${sessionScope.userName}"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="3;url=ListItems.jsp" />
        <jsp:useBean id="list" class="main.ListItemBicycles" scope="session"></jsp:useBean>
        
        
        
        <fmt:setBundle basename="main.i18n.Bundle_ru_RU" var="bundle" />
       
        <c:forEach var="cookieVal" items="${pageContext.request.cookies}" >             
            <c:choose>            
            <c:when test="${cookieVal.name == 'lang'}">              
                <c:choose>
                    <c:when test="${cookieVal.value == null}">
                        <fmt:setBundle basename="main.i18n.Bundle_en_US" var="bundle" />
                    </c:when>              
                    <c:when test="${cookieVal.value == 'langRu'}">                 
                        <fmt:setBundle basename="main.i18n.Bundle_ru_RU" var="bundle" />
                    </c:when>
                    <c:when test="${cookieVal.value == 'langUs'}">
                        <fmt:setBundle basename="main.i18n.Bundle_en_US" var="bundle" />
                    </c:when>
                    <c:when test="${cookieVal.value == 'langCh'}">
                        <fmt:setBundle basename="main.i18n.Bundle_zh_CN" var="bundle" />
                    </c:when>
                </c:choose>                
            </c:when>            
            </c:choose>     
        </c:forEach>
        
        
        <title><fmt:message key="THANKS" bundle="${bundle}"/></title>   
    </head>
    <body>
        
        
        
        <%      
        String userName_ = (String)pageContext.getAttribute("userName_");;
        String shop_=(String)pageContext.getAttribute("shopValue_");
        
                 
        for(int i=0; i<list.size();i++){
        String productTitle_=list.get(i).getTitle();      
        int  cost_=Integer.parseInt(list.get(i).getPrice());
        
        WorkingBas.add_Order_InDB(userName_,productTitle_,shop_,cost_);
        }
        %>
        <c:remove var="list" scope="session"></c:remove>
        <jsp:include page="jheader.jsp"/>
        <h3 style="padding:5px;text-align: center;"><fmt:message key="THANKS" bundle="${bundle}"/></h3>
        
    </body>
</html>
