<%-- 
    Document   : adminPage
    Created on : Oct 14, 2015, 5:34:39 PM
    Author     : huma
--%>

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
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <jsp:include page="jheader.jsp"/>
        
        <div class="admin_Main">
            
            
        <%--CONTROL PANEL --%>
          <div class="admin_Head_ControlPanel">
            
              
               <div class="admin_Head_ControlPanel_Control">
                   <button class="admin_Head_ControlPanel_Control_Add">Создать
                   <br/>
                   +1
                   </button>                     
                </div> 
              
                <div class="admin_Head_ControlPanel_Panel">
                    <table >
                       
                           
                        <tr>
                        <th ROWSPAN=3>id: <input type="text" size="5"> </th>
                        <th>title: <input type="text" size="40"></th>
                        <th>speeds: <input type="text" size="5"></th>
                        <th>brand: 
                            <select>
                            <option>Cube</option>
                            <option>Merida</option>
                            <option>Stels</option>
                            </select>
                        </th>
                        <th>wheels:

                        <select>
                            <option>Wheels26</option>
                            <option>28</option>
                            <option>29</option>
                            
                            </select>

                        </th>
                        
                        
                        
                        </tr>
                        
                        <tr>
                        <th>img1: <input type="file" name="photo1" size="5" multiple accept="image/*,image/jpeg"></th>
                        <th>weight: <input type="text" size="5"></th>
                        
                        
                       
                        <th>style:

                             <select>
                            <option>горный(MTB</option>
                            <option>дорожный</option>
                            <option>шоссейный</option>
                            </select>

                        </th>
                        
                        
                        <th>brakes:

                            <select>
                            <option>дисковые тормоза</option>
                            <option>ободной (V-Brake)</option>
                            </select>

                        </th>
                        
                        </tr>
                        
                        <tr>
                        <th>img2: <input type="file" name="photo1" size="5" multiple accept="image/*,image/jpeg"></th>
                        
                         
                        
                        <th>price: <input type="text" size="10"></th>
                        
                        <th>frame: 

                            <select>
                            <option>алюминиевый сплав</option>
                            <option>сталь</option>
                            </select>

                        </th>
                        <th>fork:

                        <select>
                            <option>амортизационная вилка</option>
                            <option>жесткая вилка</option>
                            </select>

                        </th>
                        
                        </tr>
                        </tr>
                    </table>
                </div>
              
              
              <div class="admin_Head_ControlPanel_Save">
                <button class="admin_Head_ControlPanel_Control_Add">Добавить
                       <br/>
                     в таблицу  
                </button>
                        
                </div>
              
                        
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
                        for(int i=0;i<AllBicycles.getInstance().getAllSize();i++){
                           item = AllBicycles.getInstance().getItem(i+"");
                           build_TableList.append("<tr>"+
                "<th>"+item.getId()+"</th><th>"+item.getTitle()+"</th><th>"+item.getImg()+"</th><th>"+item.getImg2()+"</th>"+
                "<th>"+item.getBrand()+"</th><th>"+item.getStyle()+"</th><th>"+item.getFrame()+"</th><th>"+item.getWheels()+"</th>"+
                "<th>"+item.getBrakes()+"</th><th>"+item.getFork()+"</th><th>"+item.getSpeeds()+"</th><th>"+item.getWeight()+"</th>"+
                "<th>"+item.getPrice()+"</th>"+
                "<th>EDIT</th><th>DEL</th>"+
                "</tr>");
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
