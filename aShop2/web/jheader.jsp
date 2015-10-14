<%@ page import="java.util.ResourceBundle"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="list" class="main.ListItemBicycles" scope="session"></jsp:useBean>

<%!String langRu = null;
String langUs = null;
String langCh = null;%>

<%Cookie[] cookiesHeader=request.getCookies();
    if (cookiesHeader==null){}else{
    for (int c = 0; c <cookiesHeader.length; c++){
    if (cookiesHeader[c].getName().equals("lang"))
    {
        if(cookiesHeader[c].getValue().equals("null")){break;}
        else if(cookiesHeader[c].getValue().equals("langRu")){langRu="langRu";}
        else if(cookiesHeader[c].getValue().equals("langUs")){langUs="langUs";}
        else if(cookiesHeader[c].getValue().equals("langCh")){langCh="langCh";}
    }}}%>


<%ResourceBundle resourceBundle;
resourceBundle=ResourceBundle.getBundle("main.i18n.Bundle",request.getLocale());
        {// LOCALE /////////////////////////////////////////////////////////////////////////////////////////////////////
        
        if (langRu != null) {
            resourceBundle=ResourceBundle.getBundle("main.i18n.Bundle_ru_RU");
            refreshFunc();
        }
        
        if (langUs != null) {
            resourceBundle=ResourceBundle.getBundle("main.i18n.Bundle_en_US");
            refreshFunc();
        }
       
        if (langCh != null) {
            resourceBundle=ResourceBundle.getBundle("main.i18n.Bundle_zh_CN");
            refreshFunc();
        }
        }%>
        
 <%!public void refreshFunc(){
        langRu = null;
        langUs = null;
        langCh = null;
    }%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
<link rel="StyleSheet" href="css/jheader-style1.css" type="text/css"/>
<script src="js/jheaderScript.js"></script>
</head>
<body >
    
<div class="header_main-content">
    <div class="header_logo">
        <!--<img class="image"/>-->
        <h1><a href="ListItems.jsp"><%=resourceBundle.getString("PRODUCT_INFORMATION")%></a></h1>
    </div>
    <div class="header_middle">
        <div class="header_middle-websearch">
               <div class="user_name_Header">         
               <h1>${pageContext.request.userPrincipal.name}</h1>
               </div>
               
        </div>
    </div>
    <div class="header_nav">
        <!--<button class="header_nav-btaction"> </button>-->
        
        <div class="selectLangDiv">
       <button class="langRuIn" name="langRu" value="" onclick="langRuInValue()"></button>
       <button class="langUsIn" name="langUs" value="" onclick="langUsInValue()"></button>
       <button class="langChIn" name="langCh" value="" onclick="langChInValue()"></button>
        </div>
            
        
        <div class="header_nav-authorization">
            <img src="img/langico/grid.png" class="image-auth"/>
            
            <div class="header_Shop">
            
            
            <c:choose>
                <c:when test="${not empty pageContext.request.userPrincipal.name}">
                    
                    <c:choose>
                        <c:when test="${list.somelistSize!=0}">
                            <div>
                                <a href="checkout.jsp">
                                    <img src="img/langico/cart.png" class="img_Order"/>
                                </a>
                            </div>
                        </c:when>
                    </c:choose>  
                </c:when>
            </c:choose>
            
        </div>
            
            
            
            
            <div class="menu_auth">
            <ul>
            <li><a href="basket.jsp"><%=resourceBundle.getString("AUTH_BUCKET")%></a></li>
            <li><a href="eventCheck.jsp"><%=resourceBundle.getString("AUTH_ENTER")%></a></li>
            <li><a href="logout.jsp"><%=resourceBundle.getString("AUTH_LOGOUT")%></a></li>
            </ul>
            </div>
        </div>
            
        
        
    </div>
</div>
            </body>
</html>
