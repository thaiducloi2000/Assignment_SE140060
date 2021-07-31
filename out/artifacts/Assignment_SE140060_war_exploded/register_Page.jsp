<%-- 
    Document   : Register_Page
    Created on : Mar 12, 2021, 9:06:21 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Register Page</title>
        <style>
            .divider-text {
                position: relative;
                text-align: center;
                margin-top: 15px;
                margin-bottom: 15px;
            }
            .divider-text span {
                padding: 7px;
                font-size: 12px;
                position: relative;   
                z-index: 2;
            }
            .divider-text:after {
                content: "";
                position: absolute;
                width: 100%;
                border-bottom: 1px solid #ddd;
                top: 55%;
                left: 0;
                z-index: 1;
            }
            .btn-google{
                background-color: #e74c3d;
                color: #fff;
            }
            .btn-facebook {
                background-color: #405D9D;
                color: #fff;
            }
            .btn-twitter {
                background-color: #42AEEC;
                color: #fff;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <br>  <p class="text-center">This web-site was create by <a href="https://www.facebook.com/loi.thaiduc.2000/"> me </a></p>
            <hr>
            <div class="card bg-light">
                <article class="card-body mx-auto" style="max-width: 400px;">
	  <h4 class="card-title mt-3 text-center">Create Account</h4>
	  <p class="text-center">Get started with your free account</p>
	  <p>
	      <a href="" class="btn btn-block btn-google"> <i class="fab fa-google"></i>   Sign in with Google </a>
	      <a href="" class="btn btn-block btn-facebook"> <i class="fab fa-facebook-f"></i>   Sign in with facebook </a>
	  </p>
	  <p class="divider-text">
	      <span class="bg-light">
	          OR
	      </span>
	  </p>
	  <form action="MainController">
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-id-badge"> </i> </span>
	          </div>
	          <input name="userID" class="form-control" placeholder="User ID" type="text" required="true"> 
	          <span>${requestScope.ERROR.userIDError}</span>
	      </div>
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-user"></i> </span>
	          </div>
	          <input name="userName" class="form-control" placeholder="User Name" type="text" required="true">
	          <span>${requestScope.ERROR.userNameError}</span>
	      </div>
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="material-icons">location_city</i> </span>
	          </div>
	          <input name="address" class="form-control" placeholder="Address" type="text" required="true">
	          <span>${requestScope.ERROR.addressError}</span>
	      </div>
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
	          </div>
	          <input name="phone" class="form-control" placeholder="Phone number" type="text" required="true">
	          <span>${requestScope.ERROR.phoneError}</span>
	      </div>
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-venus-mars" style="font-size:24px"></i> </span>
	          </div>
	          <input name="sex" class="form-control" placeholder="Gender" type="text" required="true">
	          <span>${requestScope.ERROR.sexError}</span>
	      </div>
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
	          </div>
	          <input class="form-control" placeholder="Password" type="password" name="password" required="true">
	          <span>${requestScope.ERROR.passwordError}</span>
	      </div>
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
	          </div>
	          <input class="form-control" placeholder="Confirm password" type="password" name="confirm" required="true">
	          <span>${requestScope.ERROR.passwordError}</span>
	      </div>
	      <div class="form-group">
	          <button type="submit" class="btn btn-primary btn-block" name="action" value="Create"> Create Account  </button>
	      </div> <!-- form-group// -->      
	      <p class="text-center">Have an account? <a href="Login.jsp">Log In</a> </p> 
	  </form>
                </article>
            </div>
        </div>
    </body>
</html>
