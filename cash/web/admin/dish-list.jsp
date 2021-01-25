<%-- 
    Document   : managecurrency
    Created on : Nov 6, 2014, 8:53:20 AM
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.User" %>
<%@ page import="bean.Dish" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.adminprofile == null}">
    <% response.sendRedirect(request.getContextPath() + "/admin/terminate.html"); %>
</c:if>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Dish List</title>

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
          <a class="navbar-brand" href="home.jsp"><span class="glyphicon glyphicon-home"></span> <span style="color:#FFFF00">&nbspFOODY MOODY</span></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="/cash/admin/ViewOrderServlet"><span class="glyphicon glyphicon-th-list"></span> &nbsp View Customer Orders</a></li>
            <li><a href="/cash/admin/ManageBackendDataServlet"><span class="glyphicon glyphicon-th-list"></span> &nbsp Dish List </a></li> 
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
        <h1>WELCOME TO FOODY MOODY</h1>
        <ul>
            <li>Fast delivery, deals & discounts and the best choice of restaurants. Order now! Choose your food, relax and we do the rest.</li>
        </ul>
    </div>
      
      <div class="well">
          <div class="row">            
            <div class="col-md-7">
                <h3>Dish List</h3>
            <div class="table-responsive">
                <table class="table table-striped table-hover ">
                    <thead>
                        <tr>
                            <th>Menu</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th>Status</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.dishlist}" var="dish" varStatus="loop">
                        <tr>
                            <c:url value="/admin/EditDishServlet" var="displayURLEdit">
                                <c:param name="id"   value="${dish.id}" />
                            </c:url>
                            <td><a href="<c:out value='${displayURLEdit}' />"><c:out value="${dish.menu}" /></a></td>
                            <td><c:out value="${dish.price}" /></td>
                            
                            <td><c:out value="${dish.category}" /></td>
                            
                            <c:if test="${dish.status == 'active'}">
                                <c:url value="/admin/DeactivateDishServlet" var="displayURLDeactivate">
                                    <c:param name="id"   value="${dish.id}" />
                                </c:url>
                                <td><a href="<c:out value='${displayURLDeactivate}' />"><c:out value="${dish.status}" /></a></td>
                            </c:if>
                                
                            <c:if test="${dish.status == 'deactivate'}">
                                <c:url value="/admin/ActivateDishServlet" var="displayURLActivate">
                                    <c:param name="id"   value="${dish.id}" />
                                </c:url>
                                <td><a href="<c:out value='${displayURLActivate}' />"><c:out value="${dish.status}" /></a></td>
                            </c:if>
                            
                            <c:url value="/admin/DeleteDishServlet" var="displayURLDelete">
                                <c:param name="id"   value="${dish.id}" />
                            </c:url>
                            <td><a href="<c:out value='${displayURLDelete}' />"><span class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                        </c:forEach>
                    </tbody> 
                </table>    
            </div> <!-- table-responsive -->                   
            </div>
            <div class="col-md-5">
                <h3>Add New Dish</h3>
                <div class="well">
                    <form class="form-horizontal" action="/cash/admin/RegisterDishServlet" method="post">
                        <fieldset>
                            <div class="form-group">
                                <label for="name" class="col-lg-2 control-label">Menu</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="menu" name="menu" placeholder="Menu Name" type="text" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="symbol" class="col-lg-2 control-label">Price</label>
                                <div class="col-lg-10">
                                    <input class="form-control" id="price" name="price" placeholder="Price" type="text" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="symbol" class="col-lg-2 control-label">Category</label>
                                <div class="col-lg-10">
                                    <input type="radio" id="category" name="category" value="Food">
                                    <label for="food">Food</label><br>
                                    <input type="radio" id="category" name="category" value="Drink">
                                    <label for="drink">Drink</label><br>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>    
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
