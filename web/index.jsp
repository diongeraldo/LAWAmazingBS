<%-- 
    Document   : index
    Created on : Mar 31, 2015, 12:25:38 AM
    Author     : Dion Geraldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    </head>
    
    <body>
        <div class="container">
            <div class="row" style="padding-top: 200px;">
                 <div class="col-sm-3"></div>
                  <div class="col-sm-6">
                        <b><h1 class="text-left">Login Form JSP</h1></b>
                  </div>
                 <div class="col-sm-3"></div>
            </div>
            <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <form class="form-inline center-block" action="LoginHandler" method="post">
                    <div class="form-group">
                      <input name="username" type="text" class="form-control" id="username" placeholder="Enter Name">
                    </div>
                    <div class="form-group center-block">
                      <input name="password" type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-default" id="loginButton">Sign in</button>
                </form>
            </div>
            <div class="col-sm-3"></div>
        </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </body>
</html>
