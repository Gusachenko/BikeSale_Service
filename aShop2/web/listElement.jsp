
<%@page import="main.Bicycle"%>
<%@page import="main.AllBicycles"%>
<!DOCTYPE html>

<%--<%@page import="main.XmlStreamReader"%>--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--<c:import var="goodsInfo" url="listOfGoods.xml" charEncoding="UTF-8"/>
<x:parse xml="${goodsInfo}" var="output"/>--%>


<LINK REL="StyleSheet" HREF="css/listItemstyle3.css" TYPE="text/css">
        
        <script src="js/jquery-1.11.2.min.js" type="text/javascript">
        </script>

       



<%@ page contentType="text/html;charset=UTF-8"%>
 <%
 
 
 int iter = 0;
        if (request.getParameter("iter") != null)
        {
            iter = Integer.parseInt(request.getParameter("iter"));
        }
 
//if (iter==0){iter=0;};  
//        XmlStreamReader readerEl = new XmlStreamReader();
//        readerEl.readXml(); 
        
        
        Bicycle b_item=AllBicycles.getInstance().getItem(iter+"");
    %>
    
     <script>
         
            $(document).ready(function(){ 
            $(".boxStealth").hide();
            });
            
            
            
            function loadXMLDoc(value) {
            var xmlhttp;
            
            
            
            if (window.XMLHttpRequest)
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
            else // code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            // Action to do
            
            xmlhttp.responseText;
            }
            
            xmlhttp.open("GET","addToBasket.jsp?id="+value,true);
            xmlhttp.send();
            $(".boxStealth").show();
            setTimeout(function(){$('.boxStealth').fadeOut('fast')},1000);
           }
        
            
        </script>

<div class="item">

                <div class="div_item-img">
                    <DIV class="div_item-img_pos">
                    <a href="Lshop?&iter=<%=iter%>">
                        <img class="item-img" src="<%=b_item.getImg()%>" />
                    </a>                   
                    </DIV>
                </div>
                <div class="div_item-info">
                    
                    <DIV class="title_item">
                    <a href="Lshop?&iter=<%=iter%>">
                        <b ><%=b_item.getTitle()%></b>
                    </a>
                    </DIV>
                
                <div class="lft_List">
                    <ul>
                    <li><%=b_item.getBrand()%></li>
                    <li><%=b_item.getStyle()%></li>
                    <li><%=b_item.getFrame()%></li>
                    <li><%=b_item.getWheels()%>"</li>
                    <li><%=b_item.getBrakes()%></li>
                    <li><%=b_item.getFork()%></li>
                    <li><%=b_item.getSpeeds()%> speeds</li>
                    <li>вес: <%=b_item.getWeight()%> кг</li>
                    </ul>
                </div>
                
                <div class="rt_Realm">
                    
                    <DIV class="rt_Realm_cost">
                        <DIV class="cost_div">
                            <span id="cost"><%=b_item.getPrice()%></span><span class="rouble_item">Р</span>
                        </DIV>
                    </DIV>
                    
                    <DIV class="rt_Realm_addTo">
                        <DIV class="rt_Realm_addTo_Button">
                    
                    <img src="img/langico/basket.png" class="btnBuy" onclick="loadXMLDoc(<%=iter%>)" alt="to basket"  /> 
                         
                        
                        </DIV>
                    </DIV>
                    
                </div>
                
                </div>
        </div>
                