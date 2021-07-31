<%-- 
    Document   : Login
    Created on : Mar 8, 2021, 10:28:50 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id" content="400202893725-rpls0kt99p5ldga613d67mcd1k02rlcr.apps.googleusercontent.com.apps.googleusercontent.com">
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
	  <h4 class="card-title mt-3 text-center">Login</h4>
	  <p class="text-center">Get started with your free account</p>
	  <p>
	      <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Assignment_SE140060/login-google&response_type=code&client_id=400202893725-rpls0kt99p5ldga613d67mcd1k02rlcr.apps.googleusercontent.com&approval_prompt=force" class="btn btn-block btn-google"> 
	          <i class="fab fa-google"></i>   Sign in with Google </a>

	  </p>
	  <p class="divider-text">
	      <span class="bg-light">
	          OR
	      </span>
	  </p>
	  <form action="MainController" method="post">
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-id-badge"> </i> </span>
	          </div>
	          <input type="text" name="userID" id="username" class="form-control" placeholder="User ID" required="true">
	      </div>
	      <div class="form-group input-group">
	          <div class="input-group-prepend">
	              <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
	          </div>
	          <input type="password" name="password" class="form-control" placeholder="Password" required="true">
	      </div>
	      <div class="form-group">
	          <button type="submit" class="btn btn-primary btn-block" name="action" value="Login"> Login  </button>
	      </div>
	      <p class="text-center">Don't have an account? <a href="Register_Page.jsp">Register here</a> </p>
	  </form>
                </article>
            </div>
        </div>
    </body>
    <!--    <form action="MainController" method="POST">
            User ID<input type="text"  name="userID"><br/>
            Password<input type="password" name="password"><br/>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="reset">
        </form>-->
</html>
