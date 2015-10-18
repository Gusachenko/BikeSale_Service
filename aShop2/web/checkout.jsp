
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
        
        <script src="js/jquery-1.11.2.min.js" type="text/javascript">
        </script>        
        <script src="js/jquery-2.1.3.min.js" type="text/javascript">
        </script>

        <script type="text/javascript"
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBQl6fW1nJyO6PeSo5ECOwnVglOWCOkB4s&sensor=true">
        </script>
        <script src="js/ordering.js"></script>
        
        
        
        
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
       
    <title><fmt:message key="ORDER_TYPE_TITTLE" bundle="${bundle}"/></title>
        
    </head>
    <body>
        
        <jsp:include page="jheader.jsp"/>
    
        
        <DIV class="map_DIV">
                
            
                
            <h4><fmt:message key="ORDER_TYPE_TITTLE" bundle="${bundle}"/></h4>
                <div id="map-canvas" style="height:480px; width:640px"></div>
                
                
                
                <DIV class="select_Map_Delivery_Point">
                    
                    <div class="select_TypeOrder">
                        <div class="select_TypeOrder_div">
                            <select id="typeOrder" onchange="updTypeOrder()">
                                <option selected disabled><fmt:message key="ORDER_TYPE_SELECT" bundle="${bundle}"/></option>
                                <option value="shop">Магазин</option>
                                <option value="courier">Курьер</option>
                            </select>
                        </div>
                    </div>

                    <DIV class="typeOfDelivery">

                        <DIV class="typeShop">

                            <b><fmt:message key="SHOP" bundle="${bundle}"/>:</b>
                            <select id="MarkerId" name="shopID" onchange="updMarker()">
                                <option value=0 selected disabled><fmt:message key="CHOOSE" bundle="${bundle}"/></option>
                                <option value=1>"Вело-основа" №1</option>
                                <option value=2>"Вело-основа" №2</option>
                            </select>
                            <br/>
                            <input id="ordering_type_market_accept" type="button" class="option_Padding_Button" value="<fmt:message key="NEXT" bundle="${bundle}"/>" onclick="accept_Shop_Text()">
                        </DIV>

                        <div class="typeCourier">
                            <input id="address" type="textbox" maxlength="20" value="Санкт-Петербург">
                            <input type="button" class="option_Padding" value="<fmt:message key="SPECIFY_ADRESS" bundle="${bundle}"/>" onclick="codeAddress()">
                            <br/>
                            <input type="button" class="option_Padding_Button" value="<fmt:message key="NEXT" bundle="${bundle}"/>" onclick="accept_Adress_Text()">
                        </div>

                    </DIV>
                    
                    
                    
                </DIV>
                
                
    
            
        </DIV>
        
                    
                    
        
       
    </body>
</html>