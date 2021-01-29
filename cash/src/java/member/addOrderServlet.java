/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package member;


import bean.Order;
import bean.Dish;
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
  
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session = request.getSession();
        
        ArrayList orderlist = new ArrayList();
       
        String menu = request.getParameter("menu");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String userName = request.getParameter("userName");
        
        String sqlInsert = "INSERT INTO orderdish(userName, menu, quantity, status) VALUES(?, ?, ?, 'not confirm')";
        
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlInsert);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, menu);
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
            
            String sqlQuery = "SELECT * FROM dishes WHERE id=?";
            preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1, menu);
            ResultSet rs = preparedStatement.executeQuery();
            
      
            double price = 0.0;
            String category = "";
            while (rs.next()) {
                price = rs.getDouble("price");
                category = rs.getString("category");
            }
            
            Dish dish = new Dish();
            dish.setMenu(menu);
            dish.setPrice(price);
            dish.setCategory(category);
            
        
            Order order = new Order();
            order.setMenu(menu);
            order.setUserName(userName);
            order.setQuantity(quantity);
            order.setStatus("not confirm");
            orderlist.add(order);
         
         session.setAttribute("cart", orderlist); 
            
         session.setAttribute("neworder", order);
         session.setAttribute("dish",dish);
            
            response.sendRedirect(request.getContextPath() + "/addOrderResult.jsp");
            
        }
         
        catch (SQLException ex) {
            ex.printStackTrace();
        }   
            
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
