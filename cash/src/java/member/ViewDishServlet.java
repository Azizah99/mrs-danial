/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package member;

import bean.Order;
import bean.User;
import bean.Dish;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ViewDishServlet", urlPatterns = {"/ViewDishServlet"})
public class ViewDishServlet extends HttpServlet {

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
        
        ArrayList dishList = new ArrayList();        
        
        String sqlQuery = "SELECT * FROM dishes WHERE status = 'active' ORDER BY id ASC";
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String menu = rs.getString("menu");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                String status = rs.getString("status");
                
                Dish dish = new Dish();
                dish.setId(id);
                dish.setMenu(menu);
                dish.setPrice(price);
                dish.setCategory(category);
                dish.setStatus(status);
                dishList.add(dish);
               // System.out.println("Fetch Order: " + order.getCustomer());
            }
        }
        catch (SQLException ex) {            
        }
        
        session.setAttribute("dishList", dishList);
      
       response.sendRedirect(request.getContextPath() + "/viewdish.jsp");        

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
