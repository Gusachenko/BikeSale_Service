<%@page import="dbase.TOrdering"%>
<%@page import="java.util.List"%>
<%@page import="dbase.WorkingBas"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:set var="userName" value="${pageContext.request.userPrincipal.name}" scope="session"/>   

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
        
        <script>
            
            
            
           function loadXMLDoc() {
            var xmlhttp;
            
            var comment = document.getElementById("comment-text");
            if(comment.value.length === 0) {
                alert("<fmt:message key="DELETE_ALL_BASKET" bundle="${bundle}"/>");
            return;
            }
            
            if (window.XMLHttpRequest)
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
            else // code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            // Action to do
            
            document.getElementById("RESULT").innerHTML=xmlhttp.responseText;
            }
            
            xmlhttp.open("GET","commentsAjax.jsp?&comtext="+comment.value,true);
            xmlhttp.send();
           }
           
            
            function loadComments() {
            var xmlhttp;
            
            
            
            if (window.XMLHttpRequest)
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
            else // code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            // Action to do
            
            document.getElementById("RESULT").innerHTML=xmlhttp.responseText;
            }
            
            xmlhttp.open("GET","commentsAjax.jsp",true);
            xmlhttp.send();
            document.getElementById("comment-text").value = "";
           }
           





             var locale=new String("");
             function digitalWatch()
             {

                             if (getCookie('lang')=="langRu")
                             {
                                 locale="ru-RU";
                             }
                             else if(getCookie('lang')=="langUs")
                             {
                                 locale="en-US";
                             }
                             else if (getCookie('lang')=="langCh")
                             {
                                 locale="zh-CN";
                             }




                             document.getElementById("digital_watch").innerHTML = new Date().toLocaleDateString(locale);
                             document.getElementById("digital_watch_Time").innerHTML = new Date().toLocaleTimeString(locale);





                             setTimeout("digitalWatch()", 1000);
             }
        
        </script>
        
        
        
        
    <title><fmt:message key="PERSONAL_AREA" bundle="${bundle}"/></title>
    </head>
    <body onload="loadComments();digitalWatch();">
        
        
        <jsp:include page="jheader.jsp"/>
        
        <DIV class="content_User">
            
            <h2 align="center"><fmt:message key="PERSONAL_AREA" bundle="${bundle}"/></h2>
            
            <div class="left_panel_Content_User">
                <div class="time_Watch">
                <span id="digital_watch"></span><br/>
                <span id="digital_watch_Time"></span><br/>
                </div>


                <div class="left_panel_Content_User_name"><fmt:message key="AUTH_USER" bundle="${bundle}"/> 
                ${pageContext.request.userPrincipal.name}<br/>
                </div>

                <div class="left_panel_Content_User_tabSelect">
                    <form action="eventCheck.jsp" method="get">
                     <p><select size="1" name="prefereTab" style="padding:5px;">
                     <option selected disabled><fmt:message key="CHOOSE_BAR_OPTION" bundle="${bundle}"/></option>
                     <option value="0"><fmt:message key="CHARACTERISTICS_OF" bundle="${bundle}"/></option>
                     <option  value="1"><fmt:message key="DESCRIPTION" bundle="${bundle}"/></option>
                     <option value="2"><fmt:message key="REVIEWS" bundle="${bundle}"/></option>
                    </select></p>
                    <input type="submit" value="OK"/>
                    </form>  
                </div>

                <c:choose>
                <c:when test="${not empty param.prefereTab}">
                    <c:set var="preferTabS" value="${param.prefereTab}" scope="session"/>
                    </c:when>
                </c:choose>


                <DIV class="div_Comments">
                    <p><fmt:message key="FEEDBACK_ABOUT" bundle="${bundle}"/></p>
                    
                 <textarea placeholder="<fmt:message key="FEEDBACK_ABOUT" bundle="${bundle}"/>" rows="5" cols="45" name="text" id="comment-text"></textarea>
                 
                 <br/>
                 <div class="addOrder">
                 <button  type="button" onclick="loadXMLDoc()"><fmt:message key="SEND" bundle="${bundle}"/></button>
                 </div>
                    
                    
                    
                 <div id="RESULT"></div>
                 
                 <br/>
                 
                </DIV>
            </div>



            <div class="right_panel_Content_User">
                <DIV class="div_Ordering_List">


                    <%
                        List<TOrdering> listUserItems=null;
                        listUserItems=WorkingBas.getUserElementDB((String)pageContext.getAttribute("userName", PageContext.SESSION_SCOPE));
                    %>
                    <h2 align="center"><fmt:message key="AUTH_HISTORY" bundle="${bundle}"/>:</h2>
                    <div class="div_Ordering_List_Element">
                        
                                 <ul>
                                     <% 
                                    if(listUserItems!=null){
                                    for (int i=listUserItems.size()-1;0<i;i--){
                                     %>

                                     <li><%=listUserItems.get(i).getProductTitle()%> | <%=listUserItems.get(i).getIssueDate()%>  |
                                         <%=listUserItems.get(i).getShop()%> | <%=listUserItems.get(i).getCost()%> ;</li>

                                     <%}}%>
                                 </ul>
                    </div>

               </DIV>
            </div>
                         
        </DIV>
    </body>
    
</html>
