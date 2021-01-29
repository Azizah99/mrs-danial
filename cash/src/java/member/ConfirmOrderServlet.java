/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package member;

import bean.User;
import bean.Order;
import bean.Dish;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.JDBCUtility;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ConfirmOrderServlet", urlPatterns = {"/ConfirmOrderServlet"})
public class ConfirmOrderServlet extends HttpServlet {

    private JDBCUtility jdbcUtility;
    private Connection con;
    
    public void init() throws ServletException
    {
        String driver = "com.mysql.jdbc.Driver";

        String dbName = "food_delivery";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String password = "";

        jdbcUtility = new JDBCUtility(driver,
                                      url,
                                      userName,
                                      password);

        jdbcUtility.jdbcConnect();
        con = jdbcUtility.jdbcGetConnection();
    }    
    
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
       HttpSession session = request.getSession();
        
        ArrayList orList = new ArrayList(); 
        ArrayList orDish = new ArrayList();
     
        
        User user = (User)session.getAttribute("memberprofile");
        String userName = user.getUserName();
       
        String sqlUpdate = "UPDATE orderdish SET status= 'in progress'";
                            
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {            
        }
        
        
        
        try {
            
            String sqlQuery = "SELECT * FROM orderdish " +
                              "WHERE userName = '" + userName + "'" + 
                              "ORDER BY orderID ASC" ;
            
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int orderID = Integer.parseInt(rs.getString("orderID"));
                String menu = rs.getString("menu");
               // double price = Double.parseDouble("price");
               //String menu = rs.getString("menu");
               // String category = rs.getString("category");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                String status = rs.getString("status");
              
                Order orderItem = new Order();
                orderItem.setMenu(menu);
                orderItem.setOrderID(orderID);
                orderItem.setQuantity(quantity);
                orderItem.setStatus(status);
          
                orList.add(orderItem);
                
               // System.out.println("Fetch Order: " + order.getCustomer());
           
            }
          
            
        }
        catch (SQLException ex) {            
        }
        
               session.setAttribute("orList", orList);
             //  session.setAttribute("orDish", orDish);
      
              response.sendRedirect(request.getContextPath() + "/orderlist.jsp");
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

}
