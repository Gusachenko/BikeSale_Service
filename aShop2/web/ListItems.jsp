    
<%@page import="main.AllBicycles"%>
<!DOCTYPE html>
    <%@ page contentType="text/html;charset=UTF-8"%>
    
    <%@ page import="main.Bicycle"%>
    <%--<%@ page import="main.XmlStreamReader"%>--%>
    <%@ page import="java.io.InputStream"%>
    <%@ page import="java.io.File"%>
    <%@ page import="java.io.FileInputStream"%>
    <%@ page import="java.net.URLEncoder"%>
    <%@ page import="sun.misc.BASE64Decoder"%>
    <%@ page import="java.util.ResourceBundle"%>
       
    <jsp:useBean id="reqbike" class="main.Bicycle" scope="request"/>
    <jsp:useBean id="Lsh" class="main.Lshop"/>
    
    <%-- PUBLIC VAR--%>
    <%!
        String langRu_ListItems = null;
        String langUs_ListItems = null;
        String langCh_ListItems = null;
        
        String brandGroupArray[]=null;
        String styleGroupArray[]=null;
        String wheelsGroupArray[]=null;
        String lowCostCookie="";
        String maxCostCookie="";
        
        int counter=0;
        
        String id="";
        String idArray[];
        String bufIdArray[];
        
        int count=0;
        int lowC=0;
        int maxC=0;
    %>
    <%-- END PUBLIC VAR --%>
        
    <%-- COOKIES, LANG --%>
    <%
        // READ DATA FROM XML FILE. DATA WITH UNIQUE VARIABLES 
//        XmlStreamReader reader = new XmlStreamReader();
//        reader.readXml();
        
        AllBicycles b_Instance=AllBicycles.getInstance();

        
        // BUFFER VARIABLES FOR FILTER FUNCTION
        String filterBufValue="";
        boolean filterBool_=false;    
    
        Cookie[] cookies=request.getCookies();
        Cookie cookieBrand;
        
        // CHECK LANG COOKIES
        if (cookies==null){}else{
        for (int c = 0; c <cookies.length; c++){
        if (cookies[c].getName().equals("lang"))
        {
            if(cookies[c].getValue().equals("null")){break;}
            else if(cookies[c].getValue().equals("langRu")){langRu_ListItems="langRu";}
            else if(cookies[c].getValue().equals("langUs")){langUs_ListItems="langUs";}
            else if(cookies[c].getValue().equals("langCh")){langCh_ListItems="langCh";}
        }}}
    
        ResourceBundle resourceBundle_ListItems;
        resourceBundle_ListItems=ResourceBundle.getBundle("main.i18n.Bundle",request.getLocale());
        {// LOCALE /////////////////////////////////////////////////////////////////////////////////////////////////////
            
            if (langRu_ListItems != null) {
                resourceBundle_ListItems=ResourceBundle.getBundle("main.i18n.Bundle_ru_RU");
                refreshFunc_ListItems();
            }
            
            if (langUs_ListItems != null) {
                resourceBundle_ListItems=ResourceBundle.getBundle("main.i18n.Bundle_en_US");
                refreshFunc_ListItems();
            }
           
            if (langCh_ListItems != null) {
                resourceBundle_ListItems=ResourceBundle.getBundle("main.i18n.Bundle_zh_CN");
                refreshFunc_ListItems();
            }
            }///////////////////////////////////////////////////////////////////////////////////////////////////////////
    %>
    <%-- END COOKIES, LANG --%>
    
   <%-- FUNC: REFRESH LANG VARIABLES --%>     
    <%!public void refreshFunc_ListItems(){            // Refresh Lang
        langRu_ListItems = null;
        langUs_ListItems = null;
        langCh_ListItems = null;
    }%>

    
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="StyleSheet" href="css/listItemstyle.css" type="text/css"/>
            <script src="js/jquery-1.11.2.min.js" type="text/javascript">
            </script>
            <script src="js/jquery-2.1.3.min.js" type="text/javascript">
            </script>
            <script src="js/cookiesFilter1.js"></script>
        </head>
        <body>
        
            <%-- HEADER --%>
            <div id="ttt">
            <%@ include file="jheader.jsp"%>
            </div>
            <%-- END HEADER --%>
             
            <%-- MAIN FILTER --%>
            <%
            // CHECK COOKIES , ADD TO ARRAY BUFFER
            if (cookies==null){}else{
            for (int c = 0; c <cookies.length; c++){
             if (cookies[c].getName().equals("brandGroup"))
             {
             if(cookies[c].getValue().equals("null")){brandGroupArray=null;break;}
             String res=java.net.URLDecoder.decode(cookies[c].getValue(), "Cp1251");    
             String brandGroupArrayBuf[]=res.split(",");
             brandGroupArray=brandGroupArrayBuf;
             }}}
            
            if (cookies==null){}else{
            for (int c = 0; c <cookies.length; c++){
             if (cookies[c].getName().equals("styleGroup"))
             {
             if(cookies[c].getValue().equals("null")){styleGroupArray=null;break;}
             String res=java.net.URLDecoder.decode(cookies[c].getValue(), "Cp1251");    
             String styleGroupArrayBuf[]=res.split(",");
             styleGroupArray=styleGroupArrayBuf;
             }}}
            
             if (cookies==null){}else{
            for (int c = 0; c <cookies.length; c++){
             if (cookies[c].getName().equals("wheelsGroup"))
             {
             if(cookies[c].getValue().equals("null")){wheelsGroupArray=null;break;}
             String res=java.net.URLDecoder.decode(cookies[c].getValue(), "Cp1251");    
             String wheelsGroupArrayBuf[]=res.split(",");
             wheelsGroupArray=wheelsGroupArrayBuf;
             }}}
             
             if (cookies==null){}else{
            for (int c = 0; c <cookies.length; c++){
             if (cookies[c].getName().equals("lowCost"))
             {
             if(cookies[c].getValue().equals("null")){lowCostCookie="";break;}
             lowCostCookie=cookies[c].getValue();
             }}}
             if (cookies==null){}else{
            for (int c = 0; c <cookies.length; c++){
             if (cookies[c].getName().equals("maxCost"))
             {
             if(cookies[c].getValue().equals("null")){maxCostCookie="";break;}
             maxCostCookie=cookies[c].getValue();
             }}}
             // END CHECK COOKIES
            count=0;
            // FILING
            idArray=new String[b_Instance.getAllSize()];
            bufIdArray=new String[b_Instance.getAllSize()];
            for(int i=0;i<idArray.length;i++)
            {idArray[i]=b_Instance.getItem(i+"").getId();};
            
            // APPLY VALUE FROM ARRAY BUFFER
            if(request.getParameter("valueBrand")==null && brandGroupArray==null){}else {
                        
            for(int i=0;i<idArray.length;i++){
            for(int j=0;j<brandGroupArray.length;j++){
            if((b_Instance.getItem(Integer.parseInt(idArray[i])+"").getBrand().equals((brandGroupArray[j])))){
            idArray[count]=idArray[i];
            count++;        
            }}}
            bufIdArray=idArray;
            idArray=new String[count];
            for(int i=0;i<count;i++){
            idArray[i]=bufIdArray[i];
            }
            }
            
            count=0;
            
                        
          if(request.getParameter("valueStyle")==null && styleGroupArray==null){}else {
                        
            for(int i=0;i<idArray.length;i++){
            for(int j=0;j<styleGroupArray.length;j++){
            if((b_Instance.getItem(Integer.parseInt(idArray[i])+"").getStyle().equals((styleGroupArray[j])))){
            idArray[count]=idArray[i];
            count++;        
            }}}
            bufIdArray=idArray;
            idArray=new String[count];
            for(int i=0;i<count;i++){
            idArray[i]=bufIdArray[i];
            }
            }
            
            count=0;
            

            
           if(request.getParameter("valueWheels")==null && wheelsGroupArray==null){}else {
                        
            for(int i=0;i<idArray.length;i++){
            for(int j=0;j<wheelsGroupArray.length;j++){
            if((b_Instance.getItem(Integer.parseInt(idArray[i])+"").getWheels().equals((wheelsGroupArray[j])))){
            idArray[count]=idArray[i];
            count++;        
            }}}
            bufIdArray=idArray;
            idArray=new String[count];
            for(int i=0;i<count;i++){
            idArray[i]=bufIdArray[i];
            }
            }
            
            count=0;
            
            if(lowCostCookie==null && maxCostCookie==null){}else {
            if(lowCostCookie==""){lowC=0;}else{lowC=Integer.parseInt(lowCostCookie);}
            if(maxCostCookie==""){maxC=99999;}else{maxC=Integer.parseInt(maxCostCookie);}
            for(int i=0;i<idArray.length;i++){            
            if(Integer.parseInt((b_Instance.getItem(Integer.parseInt(idArray[i])+"").getPrice())) >= lowC &&
            Integer.parseInt((b_Instance.getItem(Integer.parseInt(idArray[i])+"").getPrice())) <= maxC){
            idArray[count]=idArray[i];
            count++;        
            }}
            bufIdArray=idArray;
            idArray=new String[count];
            for(int i=0;i<count;i++){
            idArray[i]=bufIdArray[i];
            }}
            // END : APPLY VALUE FROM ARRAY BUFFER
            %>
            <%-- END MAIN FILTER --%>
            
            <%-- DIV:CONTAINER --%>
            <div class="container">
            
                <div class="catalog">
                <%
                for(int iR=0;iR<idArray.length;iR++){
                if(idArray[iR]==null){
                idArray[iR]=iR+"";
                }
                %>
                     
                <jsp:include page="listElement.jsp">
                    <jsp:param name="iter" value="<%=idArray[iR]%>"/>
                </jsp:include>
                     
                <%}%>
                
                </div>
            </div>
            <%-- END DIV:CONTAINER --%>
            
            <%-- DIV:FILTER , GENERATE FILTER VALUES --%>
            <div class="filter">     
                 
            <div align="center">
            <br/>
            
            <span class="filter_name"><%=resourceBundle_ListItems.getString("MANUFACTURER")%></span><br/>
            <%
            for (int i=0;i<b_Instance.uniqueBrandCount;i++) {
            // проход по списку объектов для фильтра
            String checked = "";
            if (cookies==null || brandGroupArray==null){}else{
            for (int j = 0; j < brandGroupArray.length; j++){
            if (b_Instance.getUniqueBrand(i).equals(brandGroupArray[j])) {
            // сравнение с выбранным id
            checked = "checked";
            }}}%>
                     
            <input type="checkbox" name="brandGroup" value="<%=b_Instance.getUniqueBrand(i)%>" <%=checked%>/>
            <%=b_Instance.getUniqueBrand(i)%><br/>
            <%}%>
    <hr/>
    
    <span class="filter_name"><%=resourceBundle_ListItems.getString("STYLE_TYPE")%></span><br/>
    <%for (int i=0;i<b_Instance.uniqueStyleCount;i++) {
            // проход по списку объектов для фильтра
            String checked = "";
            if (cookies==null || styleGroupArray==null){}else{     
            for (int j = 0; j < styleGroupArray.length; j++){
            if (b_Instance.getUniqueStyle(i).equals(styleGroupArray[j])){
            // сравнение с выбранным id
            checked = "checked";
            }}}%>                    
            <input type="checkbox" name="styleGroup" value="<%=b_Instance.getUniqueStyle(i)%>" <%=checked%>/>
            <%if(b_Instance.getUniqueStyle(i).equals("горный(MTB)")){%>
            <%=resourceBundle_ListItems.getString("STYLE_CC")%>
            <%}else 
            if(b_Instance.getUniqueStyle(i).equals("дорожный")){%>
            <%=resourceBundle_ListItems.getString("STYLE_CITY_ROAD")%>
            <%}else 
            if(b_Instance.getUniqueStyle(i).equals("шоссейный")){%>
            <%=resourceBundle_ListItems.getString("STYLE_CYCLO_CROSS")%>
            
            <%}else{%>
            <%=b_Instance.getUniqueStyle(i)%>
            <%}%><br/>
            <%}%>
    <hr/>
    
    <span class="filter_name"><%=resourceBundle_ListItems.getString("WHEELS_SIZE")%></span><br/>
    <%
            for (int i=0;i<b_Instance.uniqueWheelsCount;i++) {
            // проход по списку объектов для фильтра
            String checked = "";
            if (cookies==null || wheelsGroupArray==null){}else{
            for (int j = 0; j < wheelsGroupArray.length; j++){
            if (b_Instance.getUniqueWheels(i).equals(wheelsGroupArray[j])) {
            // сравнение с выбранным id
            checked = "checked";
            }}}%>
                     
            <input type="checkbox" name="wheelsGroup" value="<%=b_Instance.getUniqueWheels(i)%>" <%=checked%>/>
            <%=b_Instance.getUniqueWheels(i)%>"<br/>
            <%}%>
                    <hr/>
                    <b><%=resourceBundle_ListItems.getString("COST_FILTER")%>:</b>
                    <input name="lowCost" type="number" max="99999" min="1" size="7" placeholder="<%=resourceBundle_ListItems.getString("COST_FILTER_MIN")%>" value="<%=lowCostCookie%>">
                    <input name="maxCost" type="number" max="99999" min="1" size="7" placeholder="<%=resourceBundle_ListItems.getString("COST_FILTER_MAX")%>" value="<%=maxCostCookie%>">
                    <span class=rouble>Р</span>
                    <hr/>
                    <button onclick="sendFilterValue()"><%=resourceBundle_ListItems.getString("ACCEPT_FILTER")%></button>
                    
                </div>
                
            </div>
            <%-- END DIV:FILTER --%>
            
        </body>
    </html>
    
    <%brandGroupArray=null;
    styleGroupArray=null;
    wheelsGroupArray=null;
    lowCostCookie="";
    maxCostCookie="";%>