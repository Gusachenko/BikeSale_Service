
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="StyleSheet" HREF="css/basket-style.css" TYPE="text/css">
        
        
        
        
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
        
        
        
    </head>
    <body align="center">
       <jsp:include page="jheader.jsp"/>
       <div class="div_auth">
       <form method="POST" action="j_security_check">
            <h3><fmt:message key="AUTH" bundle="${bundle}"/></h3>
            <input placeholder="<fmt:message key="AUTH_LOGIN" bundle="${bundle}"/>" type="text" name="j_username"><br/>
            <input placeholder="<fmt:message key="AUTH_PASS" bundle="${bundle}"/>" type="password" name="j_password"><br/>
            
            <input type="submit" value="<fmt:message key="NEXT" bundle="${bundle}"/>" ><br/>
                         
        </form>
       </div>
       

    </body>
</html>
