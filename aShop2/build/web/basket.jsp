<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:useBean id="list" class="main.ListItemBicycles" scope="session"></jsp:useBean>

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
        
        <script src="js/jquery-1.11.2.min.js" type="text/javascript">
        </script>        
        <script src="js/jquery-2.1.3.min.js" type="text/javascript">
        </script>
        
        
        
       
    <title><fmt:message key="BASKET" bundle="${bundle}"/></title>
        
        
    </head>
    <body>
        <jsp:include page="jheader.jsp"/>
        <DIV class="container">
            <DIV class="div_subCon">

                <c:choose>
                    <c:when test="${list.somelistSize!=0}">
                        <h2><fmt:message key="YOUR_ITEMS" bundle="${bundle}"/></h2>
                        <table class="btrTab" border="0" cellpadding="1" cellspacing="1" style="width: 100%;">
                            <c:forEach items="${list.list}" var="item" varStatus="status">          
                            <tr>
                                <td>
                                    <c:out value="${status.count} "/>
                                </td> 
                                <td>
                                    <a href="Lshop?&iter=${item.id}" target="_blank">
                                    <b>${item.title}</b><br/>
                                    <img alt="" src="${item.img}" style="height: 100px; width: 150px;" />
                                    </a>
                                </td>                                                      
                                <td>
                                    <span id="cost">${item.price}</span><span class=rouble>Р</span>
                                </td>
                                <td>
                                   <b> <a href="delFromBasket.jsp?id=${item.id}"><img alt="" src="img/langico/trashcan.png" style="width: 25px; height: 25px;" /></a></b>
                                </td>
                            </tr>                    
                        </c:forEach>
                        </table>
                        <br>
                        <h3><fmt:message key="TOTAL_AMOUNT_BASKET" bundle="${bundle}"/> :<span id="cost"> ${list.priceAmount}</span><span class=rouble> Р</span></h3>



                        
                    <c:choose>
                        <c:when test="${not empty sessionScope.userName}">

                            <c:choose>
                                <c:when test="${list.somelistSize!=0}">
                                    <div>
                                        <div class="addOrder">
                                        <a href="checkout.jsp">
                                            <button class="btnToBasket" name="btnToBasket" ><fmt:message key="ORDER_BASKET" bundle="${bundle}"/></button>                   
                                        </a>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>  
                        </c:when>
                        
                                <c:when test="${list.somelistSize!=0}">
                                    <div>
                                        
                                        <fmt:message key="PLEASE" bundle="${bundle}"/>
                                    </div>
                                </c:when>
                            
                        
                    </c:choose>

                        <br/><a href="delFromBasket.jsp"><fmt:message key="DELETE_ALL_BASKET" bundle="${bundle}"/></a><br/>    



                    </c:when>
                    <c:otherwise>
                        <h2><fmt:message key="BASKET_EMPTY" bundle="${bundle}"/></h2>
                    </c:otherwise>
                </c:choose>
                </DIV>
          </DIV>
    </body>
</html>