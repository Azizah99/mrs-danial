/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import bean.CashRequest;
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
 * @author U
 */
@WebServlet(name = "CashRequestApprovalServlet", urlPatterns = {"/admin/CashRequestApprovalServlet"})
public class CashRequestApprovalServlet extends HttpServlet {
    
    
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
       
        //Get the session object
	HttpSession session = request.getSession();
        
        ArrayList rqcList = new ArrayList();  
        
        //get form data from VIEW > V-I
        String requestId = request.getParameter("requestid");
        String approvalStatus = request.getParameter("approvalstatus");
        
        if (approvalStatus.equals("Yes")) {    
            String sqlUpdate = "UPDATE cashrequest SET status = 'approve' WHERE requestid = ?";         
        
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
                preparedStatement.setString(1, requestId);
                preparedStatement.executeUpdate();
            }
            catch (SQLException ex) {            
            }
        } else {    
            String sqlUpdate = "UPDATE cashrequest SET status = 'rejected' WHERE requestid = ?";         
        
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
                preparedStatement.setString(1, requestId);
                preparedStatement.executeUpdate();
            }
            catch (SQLException ex) {            
            }
        }
        
        session.setAttribute("adminrqclist", rqcList);
        response.sendRedirect(request.getContextPath() + "/admin/ViewCashServlet");
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
