<%-- 
    Document   : viewdish
    Created on : Jan 25, 2021, 2:18:45 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.User" %>
<%@ page import="bean.Dish" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${sessionScope.memberprofile == null}">
    <% response.sendRedirect(request.getContextPath() + "/terminate.html"); %>
</c:if>

<jsp:useBean id="memberprofile" class="bean.User" scope="session" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>View Customer Order</title>

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
                    <li class="active"><a href="/cash/ViewDishServlet"><span class="glyphicon glyphicon-th-list"></span> View Dish</a></li> 
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
            <div class="row">
                <div class="col-md-12"> 
                <h3>Menu list</h3>                
                <div class="table-responsive">
                    
                    <table class="table table-striped table-hover ">
                        <thead>
                            <tr>
                                <th>Menu</th>
                                <th>Price</th>
                                <th>Category</th>
                                <th>Quantity</th>
                                <th>Add Order</th>
                            </tr>
                        </thead>
                            <tbody>
                                 
                                <c:forEach items="${sessionScope.dishList}" var="currentdishlist" varStatus="loop">                                
                                  <form action="/cash/addOrderServlet">
                                     <tr>
                                             
                                        <td><c:out value="${currentdishlist.menu}" /></td>
                                        <td><c:out value="${currentdishlist.price}" /></td>
                                        <td><c:out value="${currentdishlist.category}" /></td>
                               
                                    <td>
                                            <input type="text" id="quantity" name="quantity" placeholder="0">
                                            <input type="hidden" name="menu" value="${currentdishlist.menu}">
                                            <input type="hidden" name="userName" value="<jsp:getProperty name="memberprofile" property="userName"/>">
                                    </td>      
                                        <td> 
                                            <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span>Add</button> 
                                        </td> 
                                
                                     </tr>
                                  </form>
                                </c:forEach>
                            </tbody> 
                        </table>   
                    
                    </div> <!-- table-responsive -->
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