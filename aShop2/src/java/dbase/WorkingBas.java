/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 *
 * @author Huma
 */
public class WorkingBas extends HttpServlet {
    private static Object DateUtils;
    private Object Restrictions;

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
        PrintWriter out = response.getWriter();
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WorkingBas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WorkingBas at " + request.getContextPath() + "</h1>");
   
                
//                add_Order_InDB("nameADD","productTitle","shop",222);
               getElementDB(1,out) ;
               add_Goods_InDB("dasda2","dasda3","dasd4wwwwwwwwwwwwwvb","dasdasd5","dasdasd6",
            "dasdasd7","dasdasd8","dasdasd9","dasdasd10","dasdasd11","dasdasd12","dasdasd13");
                
                
 
            out.println("</body>");
            out.println("</html>");
        
    }
   
/*TEST operations */    
    
//private void updateInDB(Session session,PrintWriter out){
//        List<TOrdering> list=session.createCriteria(TOrdering.class).list();
//        if(list.isEmpty()){
//            out.print("<br>Обьект для обновления не найден");
//            return;
//        }
//        TOrdering t=list.get(0);
//        t.setCost(t.getCost()+50);
//        session.update(t);
//        out.print("<br>Updated:"+t.getProductTitle());
//        out.print("<br>Name:"+t.getUserName());
//        out.print("<br>Updated:"+t.getIssueDate());
//        
//    }

private void getElementDB(int element_key,PrintWriter out){
    try {
    Connection c = null;
    Statement stmt = null;
    
            try{
                
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/BikeSale_Service/DB/LiteDb/lbase.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM T_ORDERING;" );
                
                List<TOrdering> list2=new ArrayList<TOrdering>();
               
                while ( rs.next() ) {
                    
                     int id = rs.getInt("KEY_ID");
                     String  name = rs.getString("USER_NAME");
                     String product_title  = rs.getString("PRODUCT_TITLE");
                     String issue_date  = rs.getString("ISSUE_DATE");
                     String shop  = rs.getString("SHOP");
                     int cost  = rs.getInt("COST");
                     
                     

                     list2.add(new TOrdering(id,name,product_title,issue_date,shop,cost));
                     
                  }
                
//                List list2 = session.createCriteria(TOrdering.class).list();
                for (Iterator iterator = list2.iterator(); iterator.hasNext();){
                    
                    TOrdering t = (TOrdering) iterator.next();
                    out.print("<br> key_id: " + t.getId());
                    out.print("<br> user_name: " + t.userName);
                    out.print("<br> product_title: " + t.productTitle);
                    out.print("<br> issue_date: " + t.issueDate);
                    out.print("<br> shop: " + t.shop);
                    out.print("<br> get_cost: " + t.cost);
                     out.print("<hr>");
                    
                    
                }
                
                
                rs.close();
                 stmt.close();
                 c.close();
                
            } catch (Exception e) {
//                if (tx != null) tx.rollback();
                out.println(e.toString());
            } finally {
                out.println("<br>end");
//                if (session != null)
//                    session.close();
            }
            } finally {
                out.close();
        }
    
    
}
/*TEST END */


/*T_ORDERING operations */
public static void add_Order_InDB(String userName_,String productTitle_,String shop_,int cost_){
    
            Connection c = null;
            Statement stmt = null;
        
        try {
            
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 1);
        Date date = cal.getTime();
         
        
        String dateTime = dateFormat.format(date);
        
        
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/BikeSale_Service/DB/LiteDb/lbase.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql = "INSERT INTO main.T_ORDERING (USER_NAME,PRODUCT_TITLE,ISSUE_DATE,SHOP,COST) " +
                     "VALUES ('"+userName_+"', '"+productTitle_+"', '"+dateTime+"', '"+shop_+"',"+cost_+");"; 
        stmt.executeUpdate(sql);


        stmt.close();
        c.commit();
        c.close();
                    
        } catch (Exception e) {
            e.printStackTrace();
        } 
}


 public static List<TOrdering> getUser_Order_ElementDB(String userName_){
    
    if (userName_==null){
        userName_="NONE";
    }
    
    List listUserElements=null;
    
    try {
    
    Connection c = null;
    Statement stmt = null;
            
                
                
//                session = NewHibernateUtil.getSessionFactory().openSession();
//                tx = session.beginTransaction();
//                
//                listUserElements=session.createCriteria(TOrdering.class).list();
//                List list=session.createCriteria(TOrdering.class).list();
                
                
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/BikeSale_Service/DB/LiteDb/lbase.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM T_ORDERING;" );
                
                listUserElements=new ArrayList<TOrdering>();
                
                 while ( rs.next() ) {
                    
                     int id = rs.getInt("KEY_ID");
                     String  name = rs.getString("USER_NAME");
                     String product_title  = rs.getString("PRODUCT_TITLE");
                     String issue_date  = rs.getString("ISSUE_DATE");
                     String shop  = rs.getString("SHOP");
                     int cost  = rs.getInt("COST");
                     
                     if (name.equals(userName_)) listUserElements.add(new TOrdering(id,name,product_title,issue_date,shop,cost));
                     
                  }
//                 listUserElements=list2;
                
//                for (Iterator iterator = list2.iterator(); iterator.hasNext();){
//                    
//                    TOrdering t = (TOrdering) iterator.next();
//                    if (!t.getUserName().equals(userName_)){
//                        listUserElements.remove(t);
//                    }
//                    out.print("<br> key_id: " + t.getKeyId());
//                    out.print("<br> user_name: " + t.getUserName());
//                    out.print("<br> product_title: " + t.getProductTitle());
//                    out.print("<br> issue_date: " + t.getIssueDate());
//                    out.print("<br> shop: " + t.getShop());
//                    out.print("<br> get_cost: " + t.getCost());
                    
                    
//                }
                
                
                
                rs.close();
                stmt.close();
                c.close();
                
            } catch (Exception e) {
//                if (tx != null) tx.rollback();
//                out.println(e.toString());
                e.printStackTrace();
            } finally {
//                out.println("<br>end");
//                if (session != null)
//                    session.close();
            }
            
    
    return listUserElements;
}
/*T_ORDERING END */




/*T_COMMENT operations */
public static void addInCommentsDB(String userName_,String text_Comment_){
    
    Connection c = null;
    Statement stmt = null;
        
        try {
            
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 1);
        Date date = cal.getTime();
         
        
        String dateTime = dateFormat.format(date);
        
                    
                    
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/BikeSale_Service/DB/LiteDb/lbase.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql = "INSERT INTO T_COMMENTS (USER_NAME,TEXT_COMMENT,DATE) " +
                     "VALUES ('"+userName_+"', '"+text_Comment_+"', '"+dateTime+"');"; 
        stmt.executeUpdate(sql);


        stmt.close();
        c.commit();
        c.close();
                    
        } catch (Exception e) {
            e.printStackTrace();
        } 
}



public static List<TComments> getUserElement_CommentsDB(String userName_){
    
    if (userName_==null){
        userName_="NONE";
    }
    
    List listUserElements=null;
    
   
    
     Connection c = null;
    Statement stmt = null;
            
    try{
                
                
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/BikeSale_Service/DB/LiteDb/lbase.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM T_COMMENTS;" );
                
                listUserElements=new ArrayList<TComments>();
                
                
                 while ( rs.next() ) {
                    
                     int id = rs.getInt("KEY_ID");
                     String  name = rs.getString("USER_NAME");
                     String text_comment  = rs.getString("TEXT_COMMENT");
                     String date  = rs.getString("DATE");
                     
                     if(name.equals(userName_)) listUserElements.add(new TComments(id,name,text_comment,date));
                     
                  }
                 
                rs.close();
                stmt.close();
                c.close();
                 
//                 listUserElements=list2;
                
//                for (Iterator iterator = list2.iterator(); iterator.hasNext();){
//                    
//                    TComments t = (TComments) iterator.next();
//                    if (!t.getUserName().equals(userName_)){
//                        listUserElements.remove(t);
//                    }
//                    out.print("<br> key_id: " + t.getKeyId());
//                    out.print("<br> user_name: " + t.getUserName());
//                    out.print("<br> product_title: " + t.getProductTitle());
//                    out.print("<br> issue_date: " + t.getIssueDate());
//                    out.print("<br> shop: " + t.getShop());
//                    out.print("<br> get_cost: " + t.getCost());
                    
                    
//                }
                
               
                
            } catch (Exception e) {
//                if (tx != null) tx.rollback();
//                out.println(e.toString());
                e.printStackTrace();
            }
    
    return listUserElements;
}
/*T_COMMENT END */




/*T_GOODS operations */
public static void add_Goods_InDB(String title_,String img1_,String img2_,
    String brand_,String style_,String frame_,String wheels_,String brakes_,
    String fork_, String speeds_,String weight_,String price_){
    
    Connection c = null;
    Statement stmt = null;
        
    try {
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/Bike"
            + "Sale_Service/DB/LiteDb/lbase.db");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");
    
    
    stmt = c.createStatement();
    String sql = "INSERT INTO main.T_GOODS (title,img1,img2,brand,style,frame,"
            + "wheels,brakes,fork,speeds,weight,price) " +
            "VALUES ('"+title_+"','"+img1_+"','"+img2_+"','"+brand_+"','"+style_+"',"
            + " '"+frame_+"', '"+wheels_+"', '"+brakes_+"','"+fork_+"', '"+speeds_+"'"
            + ", '"+weight_+"', '"+price_+"')"; 
    stmt.executeUpdate(sql);
    
    stmt.close();
    c.commit();
    c.close();
                    
    } catch (Exception e) {
        e.printStackTrace();
    } 
    
}

public static void del_Goods_InDB(int id){
    
    Connection c = null;
    Statement stmt = null;
        
    try {
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/Bike"
            + "Sale_Service/DB/LiteDb/lbase.db");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");
    
    
    stmt = c.createStatement();
    String sql = "DELETE FROM main.T_GOODS WHERE id="+id+";";
            
    stmt.executeUpdate(sql);
    
    stmt.close();
    
    
    c.commit();
    c.close();
                    
    } catch (Exception e) {
        e.printStackTrace();
    } 
    
    
    
}

public static void upd_Goods_InDB(int id_,String title_,String img1_,String img2_,String brand_
    ,String style_,String frame_,String wheels_,String brakes_,String fork_,
    String speeds_,String weight_,String price_){
    
    
    Connection c = null;
    Statement stmt = null;
        
    try {
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/Bike"
            + "Sale_Service/DB/LiteDb/lbase.db");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");
    
    
    stmt = c.createStatement();
    String sql = "UPDATE main.T_GOODS SET  title='"+title_+"'"
            + ",img1='"+img1_+"',img2='"+img2_+"',brand='"+brand_+"',"
            + "style='"+style_+"',frame='"+frame_+"',"
            + "wheels='"+wheels_+"',brakes='"+brakes_+"',fork='"+fork_+"',"
            + "speeds='"+speeds_+"',weight='"+weight_+"',price='"+price_+"'" +
            "WHERE id="+id_+";"; 
    stmt.executeUpdate(sql);
    
    stmt.close();
    c.commit();
    c.close();
                    
    } catch (Exception e) {
        e.printStackTrace();
    } 
    
    
    
}

public static List<TGoods> get_GoodsList_InDB(){
    
    
    Connection c = null;
    Statement stmt = null;
    
    List listGoodsElements=null;
        
    try {
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:/home/huma/GitRep/BikeSale/Bike"
            + "Sale_Service/DB/LiteDb/lbase.db");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");
    
    stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery( "SELECT * FROM main.T_GOODS;" );
    
    listGoodsElements=new ArrayList<TGoods>();
    
     while ( rs.next() ) {
                    
                     int id = rs.getInt("id");
                     String  title = rs.getString("title");
                     String img1  = rs.getString("img1");
                     String img2  = rs.getString("img2");
                     String brand  = rs.getString("brand");
                     String style  = rs.getString("style");
                     String frame  = rs.getString("frame");
                     String wheels  = rs.getString("wheels");
                     String brakes  = rs.getString("brakes");
                     String fork  = rs.getString("fork");
                     String speeds  = rs.getString("speeds");
                     String weight  = rs.getString("weight");
                     String price  = rs.getString("price");
                     
                     
                     listGoodsElements.add(new TGoods(id,title,img1,img2,brand,
                     style,frame,wheels,brakes,fork,speeds,weight,price));
                     
                  }
                 
                rs.close();
                stmt.close();
                c.close();
                    
    } catch (Exception e) {
        e.printStackTrace();
    } 
    
    
    
    
    
    return listGoodsElements;
}

/*T_GOODS END */



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
        processRequest(request, response);
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

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public static List<TOrdering> getUser_Order_ElementDB(String userName_){
//    
//    if (userName_==null){
//        userName_="NONE";
//    }
//    
//    List listUserElements=null;
//    
//    try {
//    
//    Session session = null;
//    Transaction tx = null;
//            
//    try{
//                
//                
//                session = NewHibernateUtil.getSessionFactory().openSession();
//                tx = session.beginTransaction();
//                
//                listUserElements=session.createCriteria(TOrdering.class).list();
//                List list=session.createCriteria(TOrdering.class).list();
//                
//                for (Iterator iterator = list.iterator(); iterator.hasNext();){
//                    
//                    TOrdering t = (TOrdering) iterator.next();
//                    if (!t.getUserName().equals(userName_)){
//                        listUserElements.remove(t);
//                    }
////                    out.print("<br> key_id: " + t.getKeyId());
////                    out.print("<br> user_name: " + t.getUserName());
////                    out.print("<br> product_title: " + t.getProductTitle());
////                    out.print("<br> issue_date: " + t.getIssueDate());
////                    out.print("<br> shop: " + t.getShop());
////                    out.print("<br> get_cost: " + t.getCost());
//                    
//                    
//                }
//                
//                tx.commit();
//                
//            } catch (HibernateException e) {
//                if (tx != null) tx.rollback();
////                out.println(e.toString());
//            } finally {
////                out.println("<br>end");
//                if (session != null)
//                    session.close();
//            }
//            } finally {
////                out.close();
//        }
//    
//    return listUserElements;
//}
//
//
//
//
//
//
//public static void addInCommentsDB(String userName_,String text_Comment_){
//    
//        Session session = NewHibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        
//        try {
//            
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
//        
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.add(Calendar.HOUR, 1);
//        Date date = cal.getTime();
//         
//        
//        String dateTime = dateFormat.format(date);
//        
//                    tx = session.beginTransaction();             
//                    TComments newComment = new TComments();
////                    newComment.setKeyId(2);
//                    newComment.setUserName(userName_);
//                    newComment.setTextComment(text_Comment_);
//                    newComment.setDate(dateTime);
//                    session.save(newComment);
//                    tx.commit();
//                    
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//}
//
//
//
//public static List<TComments> getUserElement_CommentsDB(String userName_){
//    
//    if (userName_==null){
//        userName_="NONE";
//    }
//    
//    List listUserElements=null;
//    
//    try {
//    
//    Session session = null;
//    Transaction tx = null;
//            
//    try{
//                
//                
//                session = NewHibernateUtil.getSessionFactory().openSession();
//                tx = session.beginTransaction();
//                
//                listUserElements=session.createCriteria(TComments.class).list();
//                List list=session.createCriteria(TComments.class).list();
//                
//                for (Iterator iterator = list.iterator(); iterator.hasNext();){
//                    
//                    TComments t = (TComments) iterator.next();
//                    if (!t.getUserName().equals(userName_)){
//                        listUserElements.remove(t);
//                    }
////                    out.print("<br> key_id: " + t.getKeyId());
////                    out.print("<br> user_name: " + t.getUserName());
////                    out.print("<br> product_title: " + t.getProductTitle());
////                    out.print("<br> issue_date: " + t.getIssueDate());
////                    out.print("<br> shop: " + t.getShop());
////                    out.print("<br> get_cost: " + t.getCost());
//                    
//                    
//                }
//                
//                tx.commit();
//                
//            } catch (HibernateException e) {
//                if (tx != null) tx.rollback();
////                out.println(e.toString());
//            } finally {
////                out.println("<br>end");
//                if (session != null)
//                    session.close();
//            }
//            } finally {
////                out.close();
//        }
//    
//    return listUserElements;
//}
//



    
    
}
