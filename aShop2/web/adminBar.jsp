<%-- 
    Document   : adminPage
    Created on : Oct 14, 2015, 5:34:39 PM
    Author     : huma
--%>

<%@page import="dbase.WorkingBas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="main.Bicycle"%>
<%@page import="main.AllBicycles"%>

<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="StyleSheet" href="css/adminBar.css" type="text/css"/>
        
        <script src="js/jquery-1.11.2.min.js" type="text/javascript">
        </script>        
        <script src="js/jquery-2.1.3.min.js" type="text/javascript">
        </script>

        <script src="js/adminBarJs.js"></script>
        
        
        <title>JSP Page</title>
    </head>
    <body>
        
<%-- PUBLIC VAR--%>
    <%!
       int p_id=1;
       String p_title,p_img1,p_img2,p_brand,p_style,p_frame,p_wheels,p_brakes,
               p_fork,p_speeds,p_weight,p_price;               
//       boolean fn_add,fn_del,fn_update;
       int controlStatement; // 0 -- addTo BD , 1 -- updBD
       
       String isInputDisabled="disabled";
    %>
    <%-- END PUBLIC VAR --%>
    
    <%-- CONT-PANEL-LOGIC --%>
    <%

    if(request.getParameter("fn_add")==null){}
    else{
        
        //--CONTROL STATEMENT//
            controlStatement=0;
            isInputDisabled="";
        //--CONTROL STATEMENT//
        
        p_id=Integer.parseInt(AllBicycles.getInstance().getItem((AllBicycles.getInstance().getAllSize()-1)+"").getId())+1;
    }
    
    if(request.getParameter("fn_edit")==null){}
    else{
            //--CONTROL STATEMENT//
            controlStatement=1;
            isInputDisabled="";
            //--CONTROL STATEMENT//
            
            p_id=Integer.parseInt(request.getParameter("fn_edit"));
            
            Bicycle item=null;
            item = AllBicycles.getInstance().getItem(p_id+"");
                        
            p_title=item.getTitle();
            p_img1=item.getImg();
            p_img2=item.getImg2();
            p_brand=item.getBrand();
            p_style=item.getStyle();
            p_frame=item.getFrame();
            p_wheels=item.getWheels();
            p_brakes=item.getBrakes();
            p_fork=item.getFork();
            p_speeds=item.getSpeeds();
            p_weight=item.getWeight();
            p_price=item.getPrice();
            
            
    }
    
    if(request.getParameter("fn_del")==null){}
    else{
        WorkingBas.del_Goods_InDB(Integer.parseInt(request.getParameter("fn_del")));
        AllBicycles.instanceUpdate();       
    }
    
    if(request.getParameter("submit_Accept")==null){}
    else{
        
        isInputDisabled="disabled";
        p_id=0;
        p_title="";
        p_img1="";
        p_img2="";
        p_brand="";
        p_style="";
        p_frame="";
        p_wheels="";
        p_brakes="";
        p_fork="";
        p_speeds="";
        p_weight="";
        p_price="";
    }
    
    %>
    <%--END CONT-PANEL-LOGIC --%>
    
    
        
        <jsp:include page="jheader.jsp"/>
        
        <div class="admin_Main">
            
            
        <%--CONTROL PANEL --%>
          <div class="admin_Head_ControlPanel">
            
              
               <div class="admin_Head_ControlPanel_Control">
                   
<!--                   <button class="admin_Head_ControlPanel_Control_Add">Создать
                   <br/>
                   +1
                   </button>-->


<!--                   <FORM NAME="form1" METHOD="POST">
                       <INPUT TYPE="HIDDEN" NAME="buttonName">
                   <input id="input_add_newGoods_Bar" type="button" 
                          value="Создать +1" 
                          onclick="click_add_newGoods_Bar_Form()">
                   </FORM>-->
<!--                          
-->

<!--<form action="adminBarServlet" method="post">
    <input type="submit" name="button1" value="Button 1" />
</form>-->


                   <input id="input_add_newGoods_Bar" type="button" 
                          value="Создать +1" 
                          onclick="click_add_newGoods_Bar()">
                   
                   
                </div>
              
                <form name="postForm" action="adminBarServlet?&submit_Accept" method="post">
                <div class="admin_Head_ControlPanel_Panel">
                    
                    <table >
                       
                           
                        <tr>
                        <th ROWSPAN=3>id: 

                            
                            <input disabled type="number" min="0" max="999" size="5" value="<%=p_id%>"> </th>
                        <th>title: <input <%=isInputDisabled%> name="post_title" type="text" size="40" maxlength="20" value="<%=p_title%>"></th>
                        <th>speeds: <input <%=isInputDisabled%> name="post_speeds" type="number" min="0" max="99" size="5" value="<%=p_speeds%>"></th>
                        <th>brand: 
                            <select <%=isInputDisabled%> name="post_brand" id="select_brand">
                            <option>Cube</option>
                            <option>Merida</option>
                            <option>Stels</option>
                            </select>
                        </th>
                        <th>wheels:

                        <select <%=isInputDisabled%> name="post_wheels" id="select_wheels">
                            <option>26</option>
                            <option>28</option>
                            <option>29</option>
                            
                            </select>

                        </th>
                        
                        
                        
                        </tr>
                        
                        <tr>
                        <th>img1: <input <%=isInputDisabled%> name="post_img1" type="file"  size="5"  accept="image/*,image/jpeg"></th>
                        <th>weight: <input <%=isInputDisabled%> name="post_weight" type="number" min="0" max="100" size="5" value="<%=p_weight%>"></th>
                        
                        
                       
                        <th>style:

                            <select <%=isInputDisabled%> name="post_style" id="select_style">
                            <option>горный(MTB)</option>
                            <option>дорожный</option>
                            <option>шоссейный</option>
                            </select>

                        </th>
                        
                        
                        <th>brakes:

                            <select <%=isInputDisabled%> name="post_brakes" id="select_brakes" value="ободной (V-Brake)">
                            <option>дисковые тормоза</option>
                            <option>ободной (V-Brake)</option>
                            </select>

                        </th>
                        
                        </tr>
                        
                        <tr>
                        <th>img2: <input <%=isInputDisabled%> name="post_img2" type="file"  size="5"  accept="image/*,image/jpeg"></th>
                        
                         
                        
                        <th>price: <input <%=isInputDisabled%> name="post_price" type="number" min="0" max="99999" size="10" value="<%=p_price%>"></th>
                        
                        <th>frame: 

                            <select <%=isInputDisabled%> name="post_frame" id="select_frame">
                            <option>алюминиевый сплав</option>
                            <option>сталь</option>
                            </select>

                        </th>
                        <th>fork:

                        <select <%=isInputDisabled%> name="post_fork" id="select_fork">
                            <option >амортизационная вилка</option>
                            <option >жесткая вилка</option>
                            </select>

                        </th>
                        
                        </tr>
                        </tr>
                    </table>
                    
                </div>
              
              
              <div class="admin_Head_ControlPanel_Save">
<!--                <button class="admin_Head_ControlPanel_Control_Add">
                    Добавить
                       <br/>
                    в таблицу  
                </button>-->
                <input type="hidden" name="post_id" type="number" min="0" max="999" size="5" value="<%=p_id%>"/>
                <input type="hidden" name="controlStatement" value="<%=controlStatement%>"/>
                <input <%=isInputDisabled%> onclick="click_Submit_GoodsBar()" type="submit" name="button_submit" value="ACCEPT" />
                  
                </div><%--END admin_Head_ControlPanel_Save --%>
              </form><%--END FORML --%>
                        
            </div>  
        <%--END CONTROL PANEL --%>
            
        
        <%--TABLE ITEMS--%>
        
        <div class="admin_TableItems_body">
            
            
                
                
            <table class="admin_Table">
                
                <tr class="admin_titleTable_font">
                <th>id</th><th>title</th><th>img1</th><th>img2</th>
                <th>brand</th><th>style</th><th>frame</th><th>wheels</th>
                <th>brakes</th><th>fork</th><th>speeds</th><th>weight</th>
                <th>price</th>
                <th>EDIT</th><th>DEL</th>
                </tr>
               
                
                <%
                    StringBuilder build_TableList=new StringBuilder();
                    Bicycle item=null;
//                    ArrayList<Bicycle> allBicycles=AllBicycles.getInstance().getAllBikes();
                    
                    if (AllBicycles.getInstance()!=null){
                        for(int i=0;i<=AllBicycles.getInstance().getAllSize();i++){
                           item = AllBicycles.getInstance().getItem(i+"");
                           if(item!=null){
                           build_TableList.append("<tr>"+
                "<th>"+item.getId()+"</th><th>"+item.getTitle()+"</th><th>"+item.getImg()+"</th><th>"+item.getImg2()+"</th>"+
                "<th>"+item.getBrand()+"</th><th>"+item.getStyle()+"</th><th>"+item.getFrame()+"</th><th>"+item.getWheels()+"</th>"+
                "<th>"+item.getBrakes()+"</th><th>"+item.getFork()+"</th><th>"+item.getSpeeds()+"</th><th>"+item.getWeight()+"</th>"+
                "<th>"+item.getPrice()+"</th>"+
                "<th><input onclick=\"click_Edit_GoodsBar("+item.getId()+")\" type=\"button\" name=\"button_edit\" value=\"EDIT\" /></th>"
                +"<th><input onclick=\"click_DelItem_GoodsBar("+item.getId()+")\" type=\"button\" name=\"button_del\" value=\"DEL\" /></th>"+
                "</tr>");
                           }
                        }
                    }
                    out.println(build_TableList);
                %>
                
            </table>
                
                        
            
            
                        
        </div>
        
        <%--END TABLE ITEMS--%>
            
            
            
            
            
        </div>
        
 
        
    </body>
</html>
