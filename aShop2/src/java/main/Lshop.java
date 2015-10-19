package main;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Random;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;

//@WebServlet(name = "lshop", urlPatterns = { "/lshop" })
public class Lshop extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    String langRu = null;
    String langUs = null;
    String langCh = null;
    
    
    

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        
        
        
        
        
        Cookie[] cookiesHeader=request.getCookies();
            if (cookiesHeader==null){}else{
            for (int c = 0; c <cookiesHeader.length; c++){
            if (cookiesHeader[c].getName().equals("lang"))
            {
                if(cookiesHeader[c].getValue().equals("null")){break;}
                else if(cookiesHeader[c].getValue().equals("langRu")){langRu="langRu";}
                else if(cookiesHeader[c].getValue().equals("langUs")){langUs="langUs";}
                else if(cookiesHeader[c].getValue().equals("langCh")){langCh="langCh";}
            }}}
        
        
        ResourceBundle resourceBundle;    
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
        }
        
        
        
        out.println("<html>");
        out.println("<head><title>" + resourceBundle.getString("MORE_INFO") + "</title>");



        out.println("<LINK REL=\"StyleSheet\" HREF=\"css/style.css\" TYPE=\"text/css\">"+
                    "<LINK REL=\"StyleSheet\" HREF=\"css/fotorama.css\" TYPE=\"text/css\">"+
                    
                    "<script src=\"js/jquery-1.11.2.min.js\" type=\"text/javascript\">"+                   
                    "<script language=\"text/javascript\" src=\"js/jquery-1.11.2.min.js\">"+
                    "</script>");
        
        HttpSession session = request.getSession(true);
        String prefTabs = (String) session.getAttribute("preferTabS");
        if (prefTabs==null){prefTabs="0";};
        out.println("<script id=\"descriptionItem\" currentTab=\""+prefTabs+"\" src=\"js/descriptionBar.js\"></script>" +
                    "<script src=\"js/fotorama.js\"></script>");
        
        

        out.println("</head>");
        out.println("<body>");
        
        //////////////////////////////////////////////////////////////////////////
        
        
        out.println("<div class=\"mainHeader\">");
        this.getServletContext().getRequestDispatcher("/jheader.jsp").include(request, response);
        out.println("</div>");
        
        // GENERATE CONTENT ////////////////////////////////////////////////////////
//        int iter = Integer.parseInt(request.getParameter("iter"));
        
        
        
        int iter = 0;
        if (request.getParameter("iter") != null)
        {
            iter = Integer.parseInt(request.getParameter("iter"));
        }
        
        String addItemTrueOrFalse = "";
        if (request.getParameter("addItem") != null)
        {
            addItemTrueOrFalse = request.getParameter("addItem");
        }
        
        
        
//        XmlStreamReader reader = new XmlStreamReader();
//        try {                  
//           reader.readXml();
//        } catch (Exception e) {
//            // TODO: Add catch code
//            e.printStackTrace();
//        }
        Bicycle b_item=AllBicycles.getInstance().getItem(iter+"");

        { ////////////////////////////////////////////////////////////////////////// content
            out.println("<div id=\"content\">");
            

            { // navigation inform
                out.println("<ul id=\"info-nav\">");
                out.println(" <li><a href=\"#intro\">" + resourceBundle.getString("CHARACTERISTICS_OF") + "</a></li>");
                out.println("<li><a href=\"#about\">" + resourceBundle.getString("DESCRIPTION") + "</a></li>");
                out.println(" <li><a href=\"#disclaimer\">" + resourceBundle.getString("REVIEWS") + "</a></li>");
                out.println(" </ul>");

                
                
                out.println("<div id=\"info\">\n" + "<span id=\"intro\"><p>\n"
                    +        
                    "<ul>\n" +
                    "                <li>"+b_item.getBrand()+"</li>\n" + 
                    "                <li>"+b_item.getStyle()+"</li>\n" + 
                    "</ul>\n"
                    +
                    "</p></span>\n" + "<span id=\"about\"><p>\n" +
                                
                    "<ul>\n" +   
                    "                <li>"+b_item.getBrand()+"</li>\n" + 
                    "                <li>"+b_item.getStyle()+"</li>\n" + 
                    "                <li>"+b_item.getFrame()+"</li>\n" + 
                    "                <li>"+b_item.getWheels()+"\"</li>\n" + 
                    "                <li>"+b_item.getBrakes()+"</li>\n" + 
                    "                <li>"+b_item.getFork()+"</li>\n" + 
                    "                <li>"+b_item.getSpeeds()+" : speeds</li>\n" + 
                    "                <li>вес: "+b_item.getWeight()+" кг</li>\n" + 
                    "</ul>\n"+
                            
                            "</p></span>\n" +
                            "<span id=\"disclaimer\"><p>\n" +
                            "User : This is a nice Bike! ;)" + "</p></span></div>");


            }

            out.println("<span id=\"cost\">"+b_item.getPrice()+"</span><span class=rouble>Р</span>");
            out.println("<div class=\"addOrder\">");
//            &#8399;
  


//            out.println("<button class=\"btnToBasket\" name=\"btnToBasket\" onclick=\"addToBasket()\">"+resourceBundle.getString("ADD_TO_CART")+"</button>");
            out.println("<a href=\"addToBasket.jsp?id="+iter+"\"><button class=\"btnToBasket\" name=\"btnToBasket\" >"+resourceBundle.getString("ADD_TO_CART")+"</button></a><br/>");
//            out.println("<input type=submit name=\"langRu\" value=\""+resourceBundle.getString("ADD_TO_CART")+"\">");
            
            if (addItemTrueOrFalse.equals("")){}else{
            out.println("<div class=\"boxStealth\">");
            out.println("<span \">"+resourceBundle.getString("ADDED_TO_CART")+"</span>");
            out.println("</div>");}
            
            
            


            out.println("</div>");


            out.println("</div>");
        }
        //////////////////////////////////////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////// photoOfGoods
        out.println("<div id=\"photoOfGoods\">");

        out.println("        <div class=\"fotorama\">\n" + 
        "          <img src=\""+b_item.getImg()+"\">\n" + 
        "          <img src=\""+b_item.getImg2()+"\">\n" + 
        "        </div>");
        
        out.println("</div>");
        //////////////////////////////////////////////////////////////////////////



        
        
        
        
                                                
                
        
        
        /////////////////////////////////////////////////////////////////////////////////////



        out.println("</body></html>");
        out.close();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
        
        //        response.setContentType(CONTENT_TYPE);
        //        PrintWriter out = response.getWriter();
        //        out.println("<html>");
        //        out.println("<head><title>l3shop</title></head>");
        //        out.println("<body>");
        //        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        //        out.println("</body></html>");
        //        out.close();
    }
    
    
    public void refreshFunc(){
        langRu = null;
        langUs = null;
        langCh = null;
    }
}


