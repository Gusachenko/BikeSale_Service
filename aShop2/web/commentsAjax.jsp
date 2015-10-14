<%@page import="java.net.URLDecoder"%>
<%@page import="dbase.TComments"%>
<%@page import="java.util.List"%>
<%@page import="dbase.WorkingBas"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link REL="StyleSheet" HREF="css/basket-style.css" TYPE="text/css">
        <title><fmt:message key="AUTH" bundle="${bundle}"/></title>
    </head>
    <body>
        
    <c:set var="userName_" value="${sessionScope.userName}"/>
    
    
    
    <c:choose>
            <c:when test="${not empty param.comtext}">
    
    <%      
        String userName_ = (String)pageContext.getAttribute("userName_");;
        String comment_=request.getParameter("comtext");
        
                 
       
        WorkingBas.addInCommentsDB(userName_,comment_);
        
        %>
        
            </c:when>
    </c:choose>
    
    
    
    
    
    
    
    
       
       <c:choose>
            <c:when test="${not empty sessionScope.userName}">
              
                <%List<TComments> listUserItems=null;                
                    listUserItems=WorkingBas.getUserElement_CommentsDB((String)pageContext.getAttribute("userName_"));%>

                <div class="div_Comments_List">
                             
                                 
                    <%if(listUserItems!=null){
                    for (int i=listUserItems.size()-1;i>0;i--){%>
                                
                                    <div class="div_Comments_List_Element">
                                        
                                        <div class="div_Comments_List_Element_date">
                                        <%=listUserItems.get(i).getDate()%>
                                        </div>
                                        
                                        <div class="div_Comments_List_Element_comment">
                                            <p><%=listUserItems.get(i).getTextComment()%></p>
                                        </div>
                                    </div>
                                 <%}}%>
                            
                </div>
                    
            </c:when>
       </c:choose>
        
    </body>
    
</html>
