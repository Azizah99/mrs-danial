/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package member;


import bean.Order;
import bean.Dish;
import bean.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.JDBCUtility;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author Lenovo
 */
@WebServlet(name = "DeleteOrderServlet", urlPatterns = {"/DeleteOrderServlet"})

public class DeleteOrderServlet extends HttpServlet {

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
        User user = (User)session.getAttribute("memberprofile");
        String userName = user.getUserName();
        ArrayList orList = new ArrayList();
       
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        
        
        String sqlUpdate = "DELETE FROM orderdish WHERE orderID=? ";
        
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, orderID);
            preparedStatement.executeUpdate();
            
            String sqlQuery = "SELECT * FROM orderdish " +
                          "WHERE userName = '" + userName + "'" + 
                          "AND status = 'not confirm'" +
                          "ORDER BY orderID ASC" ;
            
            preparedStatement = con.prepareStatement(sqlQuery);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
         
            String menu =rs.getString("menu");
            int quantity = Integer.parseInt(rs.getString("quantity"));
            String status = rs.getString("status");
            
               Order orderItem = new Order();
                orderItem.setMenu(menu);
                orderItem.setOrderID(orderID);
                orderItem.setQuantity(quantity);
                orderItem.setStatus(status);
          
                orList.add(orderItem);
                
              
            }  
        }
         
        catch (SQLException ex) {
            ex.printStackTrace();
        }   
          session.setAttribute("cart", orList);
          response.sendRedirect(request.getContextPath() + "/cartlist.jsp");
        }
    
     void sendPage(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException, IOException
    {
        // Get the dispatcher; it gets the main page to the user
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(fileName);

        if (dispatcher == null)
        {
            System.out.println("There was no dispatcher");
            // No dispatcher means the html file could not be found.
            response.sendError(response.SC_NO_CONTENT);
        }
        else
            dispatcher.forward(request, response);
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
