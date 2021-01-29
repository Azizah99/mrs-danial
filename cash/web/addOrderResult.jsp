<%-- 
    Document   : addOrderResult
    Created on : Jan 25, 2021, 7:30:20 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.User" %>
<%@ page import="bean.Dish" %>
<%@ page import="bean.Order" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.memberprofile == null}">
    <% response.sendRedirect(request.getContextPath() + "/terminate.html"); %>
</c:if>

<jsp:useBean id="memberprofile" class="bean.User" scope="session" />
<jsp:useBean id="dish" class="bean.Dish" scope="session" />
<jsp:useBean id="neworder" class="bean.Order" scope="session" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Added to cart</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/navbar-fixed-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
           <li><a href="/cash/ViewDishServlet">View Dish List</a></li>
            <li><a href="/cash/ViewCartServlet"><span class="glyphicon glyphicon-th-list"></span> View Cart</a></li>
            <li><a href="/cash/ViewOrderServlet"><span class="glyphicon glyphicon-th-list"></span> View Order</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
      		<li class="dropdown">
		        <a aria-expanded="false" href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Welcome
                            <span style="color:#FFFF00"><jsp:getProperty name="memberprofile" property="fullName"/></span>
                            (Member) <b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="/cash/memberprofile.jsp"><span class="glyphicon glyphicon-user"></span> User Profile</a></li>
			          <li><a href="/cash/MemberSettingServlet"><span class="glyphicon glyphicon-cog"></span> Setting</a></li>
			          <li class="divider"></li>
			          <li><a href="/cash/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			        </ul>
		  	</li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
            <h1>WELCOME TO FOODY MOODY</h1>
            <ul>
                <li>Fast delivery, deals & discounts and the best choice of restaurants. Order now! Choose your food, relax and we do the rest.</li>
            </ul>
        </div>
    
      
     <div class="well">
           
      
        <h3>Add to Cart Status</h3>
       
        <div class="row">
            <div class="col-md-12">
                Add order Successful<br />
                Menu <jsp:getProperty name="dish" property="menu"/><br />
                Quantity <jsp:getProperty name="neworder" property="quantity"/><br />
                Back to <button class="btn btn-primary"><a href="/cash/ViewDishServlet">View Dish</a></button>
            </div>
        </div>
      </div>      
           
   
      <footer>
      	<p>Copyright &copy; 2021 FoodyMoody</p>
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