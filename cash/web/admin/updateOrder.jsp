<%-- 
    Document   : crqapproval
    Created on : Nov 7, 2014, 3:37:35 PM
    Author     : U
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.User" %>

<c:if test="${sessionScope.adminprofile == null}">
    <% response.sendRedirect(request.getContextPath() + "/admin/terminate.html"); %>
</c:if>

<jsp:useBean id="crq" class="bean.Order" scope="page">
    <jsp:setProperty name="crq" property="login" value="${param.login}"/>
    <jsp:setProperty name="crq" property="symbol" value="${param.symbol}"/>
    <jsp:setProperty name="crq" property="amount" value="${param.amount}"/>
    <jsp:setProperty name="crq" property="requestId" value="${param.requestid}"/>
</jsp:useBean>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Cash - Admin - Cash Request Approval</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/navbar-fixed-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home.jsp"><span class="glyphicon glyphicon-home"></span> <span style="color:#FFFF00">CashWeb</span></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="/cash/admin/ViewUsersServlet"><span class="glyphicon glyphicon-th-list"></span> Manage Users</a></li>
            <li class="active"><a href="/cash/admin/ViewCashServlet"><span class="glyphicon glyphicon-th-list"></span> View Cash Request</a></li>
            <li><a href="/cash/admin/ManageBackendDataServlet"><span class="glyphicon glyphicon-th-list"></span> Manage Backend Data</a></li> 
          </ul>
          <ul class="nav navbar-nav navbar-right">
      		<li class="dropdown">
		        <a aria-expanded="false" href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Welcome 
                            <c:if test="${sessionScope.adminprofile != null}">
                                <jsp:useBean id="adminprofile" class="bean.User" scope="session" />
                                <span style="color:#FFFF00"><jsp:getProperty name="adminprofile" property="fullName"/></span>
                            </c:if> 
                            (Admin) <b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="/cash/admin/UserProfileServlet"><span class="glyphicon glyphicon-user"></span> User Profile</a></li>
			          <li><a href="/cash/admin/SettingServlet"><span class="glyphicon glyphicon-cog"></span> Setting</a></li>
			          <li class="divider"></li>
			          <li><a href="/cash/admin/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			        </ul>
		  	</li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Cash Web-App example</h1>
        <ul>
          <li>Responsive application</li>
          <li>Bootstrap CSS</li>
          <li>MVC
            <ul>
              <li>(M)odel - JavaBeans</li>
              <li>(V)iew - JSP for input and output</li>
              <li>(C)ontroller - Servlet</li>
            </ul>
          </li>
        </ul>
      </div>
      
      <div class="well">
        <h3>Cash Request Approval</h3>
        <p>&nbsp;</p>
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" action="/cash/admin/CashRequestApprovalServlet" method="post">
                    <fieldset>
                        <div class="form-group">
                            <label for="login" class="col-lg-2 control-label">Login</label>
                            <div class="col-lg-10">
                                <input class="form-control" id="login" name="login" value="<jsp:getProperty name="crq" property="login"/>" type="text" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="currency" class="col-lg-2 control-label">Currency</label>
                            <div class="col-lg-10">
                                <input class="form-control" id="currency" name="currency" value="<jsp:getProperty name="crq" property="symbol"/>" type="text" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="amount" class="col-lg-2 control-label">Amount</label>
                            <div class="col-lg-10">
                                <input class="form-control" id="amount" name="amount" value="<jsp:getProperty name="crq" property="amount"/>" type="text" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="approvalstatus" class="col-lg-2 control-label">Approval</label>
                            <div class="col-lg-10">
                                <select class="form-control" id="approvalstatus" name="approvalstatus" required>
                                    <option >No</option>
                                    <option >Yes</option>
                                </select>
                            </div>
                        </div>       
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <input type="hidden" name="requestid" value="<jsp:getProperty name="crq" property="requestId"/>">
                                <button class="btn btn-default"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                                <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span> Submit</button>
                            </div>
                        </div>                             
                    </fieldset>
                </form>                
            </div>
        </div>
      </div>      
      
      <footer>
      	<p>&copy; RBK 2014 - SCJ/SCSJ 2303/3303</p>
      </footer>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
