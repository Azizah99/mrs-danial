<%-- 
    Document   : logout
    Created on : Nov 5, 2014, 5:06:40 PM
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    session.invalidate();
    response.sendRedirect("/cash/admin/terminate.html"); 
%>
