/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package member;


import bean.Order;
import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "addOrderServlet", urlPatterns = {"/addOrderServlet"})

public class addOrderServlet extends HttpServlet {

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        
        
        if (command == "ADD")
            addOrder(request, response);
    }
    
    
    public void addOrder(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
         HttpSession session = request.getSession();
        
        ArrayList newOrder = new ArrayList();
        
     
        Order order = new Order();
        User user = (User)session.getAttribute("memberprofile");
        String userName = user.getUserName();
        int userID = user.getId();
        
        
        int menuID = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
   
        String sqlInsert = "INSERT INTO orderdish(customer, menu, quantity, status) VALUES(?, ?, ?, 'in process')";
  
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlInsert);
            
            preparedStatement.setInt(1,userID);
            preparedStatement.setInt(2,menuID);
             preparedStatement.setInt(3,quantity);
            ResultSet rs = preparedStatement.executeQuery();
            
          order.setMenu(menuID);
          order.setCustomer(userID);
          order.setStatus("in progress");
          newOrder.add(order);
          
          session.setAttribute("newOrder", newOrder);
        //go to page
      RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/edit_information.jsp");
            request.setAttribute("newOrder", newOrder);
            request.setAttribute("alumniAddress", alumniAddress);
            dispatcher.forward(request, response);
        }
        catch (SQLException ex) {            
        }
        
          
    }
    
    
    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
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
