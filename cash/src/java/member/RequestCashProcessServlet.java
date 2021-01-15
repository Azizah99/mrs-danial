/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package member;

import bean.CashRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "RequestCashProcessServlet", urlPatterns = {"/RequestCashProcessServlet"})
public class RequestCashProcessServlet extends HttpServlet {
    
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

        //get form data from VIEW > V-I
        String amount = request.getParameter("amount");
        String currencyId = request.getParameter("currencyid");
        String login = request.getParameter("login");
        
        String sqlInsert = "INSERT INTO cashrequest(login, amount, status, currency_id) VALUES(?, ?, 'in process', ?)"; 
 
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlInsert);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, amount);
            preparedStatement.setString(3, currencyId);
            preparedStatement.executeUpdate();
            
            //get symbol using id
            String sqlQuery = "SELECT symbol FROM currency WHERE id = ?";            
            preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1, currencyId);
            ResultSet rs = preparedStatement.executeQuery();
            
            String symbol = "";
            while (rs.next()) {
                symbol = rs.getString("symbol");
            }
            
            CashRequest rqc = new CashRequest();
            rqc.setSymbol(symbol);
            rqc.setAmount(Double.parseDouble(amount));
            rqc.setStatus("in process");
            
            HttpSession session = request.getSession();
            session.setAttribute("rqc", rqc);            
            response.sendRedirect(request.getContextPath() + "/reqcashstatus.jsp");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
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
