/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import bean.Currency;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author MSI
 */
@WebServlet(name = "EditCurrencyProcessServlet", urlPatterns = {"/admin/EditCurrencyProcessServlet"})
public class EditCurrencyProcessServlet extends HttpServlet {

    private JDBCUtility jdbcUtility;
    private Connection con;
    
    public void init() throws ServletException
    {
        String driver = "com.mysql.jdbc.Driver";

        String dbName = "cash";
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
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get the session object
	HttpSession session = request.getSession();
        
        ArrayList currenyList = new ArrayList();  
        
        //get form data from VIEW > V-I
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String symbol = request.getParameter("symbol");
        
        String sqlUpdate = "UPDATE currency SET name= ?, symbol = ? WHERE id = ?"; 
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, symbol);
            preparedStatement.setString(3, id);
            preparedStatement.executeUpdate();
            
            String sqlQuery = "SELECT * FROM currency ORDER BY name ASC";
            
            preparedStatement = con.prepareStatement(sqlQuery);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String currencyName = rs.getString("name");
                String currencySymbol = rs.getString("symbol");
                String currencyStatus = rs.getString("status");
                int currencyId = rs.getInt("id");
                
                Currency currency = new Currency();
                currency.setName(currencyName);
                currency.setSymbol(currencySymbol);
                currency.setStatus(currencyStatus);
                currency.setId(currencyId);
                currenyList.add(currency);
            }
        }
        catch (SQLException ex) {            
        }
        
        session.setAttribute("currencylist", currenyList);
        response.sendRedirect(request.getContextPath() + "/admin/managecurrency.jsp");        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
