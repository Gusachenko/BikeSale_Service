/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dbase.WorkingBas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huma
 */
public class adminBarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminBar</title>");            
            out.println("</head>");
            out.println("<body>");
           
            
            out.println("<h1>Servlet adminBar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int p_id=0;
        String p_title,p_img1,p_img2,p_brand,p_style,p_frame,p_wheels,p_brakes,
        p_fork,p_speeds,p_weight,p_price;               
        float fn_add,fn_del,fn_update;
        
        
        
        if (request.getParameter("button_submit") != null) {
            
            System.out.println(request.getParameter("button_submit"));
        }
        
        System.out.println(request.getParameter("button_submit").toString());
        
        
        
        
        
        p_id = Integer.parseInt(request.getParameter("post_id"));
        p_title = new String(request.getParameter("post_title").getBytes("ISO-8859-1"), "UTF-8");
        if(request.getParameter("post_img1")!=null){
            p_img1 = "img/bicycles/road/"+new String(request.getParameter("post_img1").getBytes("ISO-8859-1"), "UTF-8");
        }else p_img1="img/bicycles/road/";               
        if(request.getParameter("post_img2")!=null){
            p_img2 = "img/bicycles/road/"+new String(request.getParameter("post_img1").getBytes("ISO-8859-1"), "UTF-8");
        }else p_img2="img/bicycles/road/";
        p_brand = new String(request.getParameter("post_brand").getBytes("ISO-8859-1"), "UTF-8");
        p_style = new String(request.getParameter("post_style").getBytes("ISO-8859-1"), "UTF-8");
        p_frame = new String(request.getParameter("post_frame").getBytes("ISO-8859-1"), "UTF-8");
        p_wheels = new String(request.getParameter("post_wheels").getBytes("ISO-8859-1"), "UTF-8");
        p_brakes = new String(request.getParameter("post_brakes").getBytes("ISO-8859-1"), "UTF-8");
        p_fork = new String(request.getParameter("post_fork").getBytes("ISO-8859-1"), "UTF-8");
        p_speeds = new String(request.getParameter("post_speeds").getBytes("ISO-8859-1"), "UTF-8");
        p_weight = new String(request.getParameter("post_weight").getBytes("ISO-8859-1"), "UTF-8");
        p_price = new String(request.getParameter("post_price").getBytes("ISO-8859-1"), "UTF-8");
        
        System.out.println(request.getParameter("controlStatement"));
        if(Integer.parseInt(request.getParameter("controlStatement"))==0){
            WorkingBas.add_Goods_InDB(p_title, p_img1, p_img2, p_brand, p_style, p_frame, p_wheels, p_brakes,
                    p_fork, p_speeds, p_weight, p_price);
        }
        
        if(Integer.parseInt(request.getParameter("controlStatement"))==1){
            WorkingBas.upd_Goods_InDB(p_id, p_title, p_img1, p_img2, p_brand, p_style, p_frame, p_wheels, p_brakes, p_fork, 
                    p_speeds, p_weight, p_price);
        }
        
        
        AllBicycles.instanceUpdate();
        
//        System.out.println(request.getParameter("select_fork").toString().getBytes( "ISO-8859-1" ));
        System.out.println(p_id+" | "+p_title+" \\ "+p_img1+" \\ "+p_img2+" \\ "+p_brand+" "
                + "\\ "+p_style+" \\ "+p_frame+" \\ "+p_wheels+" \\ "+p_brakes+" "
                + "\\ "+p_fork+" \\ "+p_speeds+" \\ "+p_weight+" \\ "+p_price);
        request.getRequestDispatcher("adminBar.jsp").forward(request, response);       
//        processRequest(request, response);
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
