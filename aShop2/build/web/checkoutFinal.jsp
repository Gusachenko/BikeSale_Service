
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<jsp:useBean id="list" class="main.ListItemBicycles" scope="session"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="StyleSheet" HREF="css/basket-style.css" TYPE="text/css">
        
       <c:choose>
          <c:when test="${not empty param.adressText}">
             <c:set var="shopSession" value="${param.adressText}" scope="session"/>                   
          </c:when>                    
       </c:choose>
        
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
       
    <title><fmt:message key="YOUR_ITEMS" bundle="${bundle}"/></title>
        
    </head>
    <body>
        
        <jsp:include page="jheader.jsp"/>
    
        
        
        
        <h2><fmt:message key="YOUR_ITEMS" bundle="${bundle}"/></h2>
        
        <DIV class="final_Div">
            
            <DIV class="final_Items">
                
                
                <c:choose>
                <c:when test="${list.somelistSize!=0}">

                    

                        

                        
                        <c:forEach items="${list.list}" var="item" varStatus="status">
                            
                                
                                <div class="item_checkout">

                                    <div class="count_item">
                                        <c:out value="${status.count} "/>
                                    </div>

                                    <div class="item_checkout_img">
                                        <a href="Lshop?&iter=${item.id}" target="_blank">
                                            <img alt="" src="${item.img}" style="height: 100%; width: 100%;" />
                                        </a>   
                                    </div>

                                    <div class="item_checkout_info">
                                        <a href="Lshop?&iter=${item.id}" target="_blank">
                                            <b>${item.title}</b><br/>
                                        </a>
                                        <span id="cost">${item.price}</span><span class=rouble>Р</span>
                                    </div>

                                </div>
                                    
                            

                        </c:forEach>
                            
                        
                    
                </div>
                
                <DIV class="final_Right_Panel">    
                
                        <DIV class="final_Total_Info">
                            
                            <p><fmt:message key="TOTAL_AMOUNT_BASKET" bundle="${bundle}"/> :<span id="cost"> ${list.priceAmount}</span><span class=rouble> Р</span></p>
                            
                            <p><fmt:message key="BUYING_PLACE" bundle="${bundle}"/>: 
                            <c:choose>
                                <c:when test="${not empty param.adressText}">
                                        ${param.adressText}
                                </c:when>                    
                            </c:choose>
                            </p>
                            
                            
                        </div>


                        



                        <div class="order_Verify_Button">
                            <div class="addOrder">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.userName}">
                                        <a href="checkoutAccept.jsp">
                                            <button><fmt:message key="ORDER_BASKET" bundle="${bundle}"/></button>
                                        </a>
                                    </c:when>
                                </c:choose>
                            </div>
                            <p><a href="delFromBasket.jsp"><fmt:message key="DELETE_ALL_BASKET" bundle="${bundle}"/></a><br/></p>
                        </div>


                </DIV> 

                  


                    </c:when>

                    <c:otherwise>
                        <h2><fmt:message key="BASKET_EMPTY" bundle="${bundle}"/></h2>
                    </c:otherwise>




            </c:choose>
        </DIV>
                    
                    
        
       
    </body>
</html>