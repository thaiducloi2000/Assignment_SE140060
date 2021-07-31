<%-- 
    Document   : ViewCart
    Created on : Mar 15, 2021, 10:50:39 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <title>View Cart Page</title>
        <style>
            .bloc_left_price {
                color: #c01508;
                text-align: center;
                font-weight: bold;
                font-size: 150%;
            }
            .category_block li:hover {
                background-color: #007bff;
            }
            .category_block li:hover a {
                color: #ffffff;
            }
            .category_block li a {
                color: #343a40;
            }
            .add_to_cart_block .price {
                color: #c01508;
                text-align: center;
                font-weight: bold;
                font-size: 200%;
                margin-bottom: 0;
            }
            .add_to_cart_block .price_discounted {
                color: #343a40;
                text-align: center;
                text-decoration: line-through;
                font-size: 140%;
            }
            .product_rassurance {
                padding: 10px;
                margin-top: 15px;
                background: #ffffff;
                border: 1px solid #6c757d;
                color: #6c757d;
            }
            .product_rassurance .list-inline {
                margin-bottom: 0;
                text-transform: uppercase;
                text-align: center;
            }
            .product_rassurance .list-inline li:hover {
                color: #343a40;
            }
            .reviews_product .fa-star {
                color: gold;
            }
            .pagination {
                margin-top: 20px;
            }
            footer {
                background: #343a40;
                padding: 40px;
            }
            footer a {
                color: #f8f9fa!important
            }
        </style>
    </head>
    <body>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">View Cart Page</h1>
            </div>
        </section>
        <div class="container mb-4">
            <div class="row">
                <div class="col-12">
	  <div class="table-responsive">
	      <c:if test="${sessionScope.CART != null}">          
	          <table class="table table-striped">
	              <thead>
		<tr>
		    <th>No</th>
		    <th>ID</th>
		    <th>Name</th>
		    <th>Price</th>
		    <th>Quantity</th>
		    <th>Total</th>
		</tr>
	              </thead>
	              <tbody>
		<c:set var="total" value="${0}"/>            
		<c:forEach var="product" varStatus="counter" items="${sessionScope.CART.getCart().values()}">                        
		    <c:set var="total" value="${total+ product.proPrice* product.quantity}"/>                       
		<form action ="MainController">
		    <tr>
		        <td>${counter.count}</td>
		        <td><input type="text" name="productID" value ="${product.proID}" readonly="true"/>
		        </td>
		        <td>${product.proName}</td>
		        <td>${product.proPrice} $</td>
		        <td><input type="number" name="quantity" value="${product.quantity}" required="true"/>
		        </td>
		        <td>${product.proPrice * product.quantity} $</td>
		        <td class="text-right">
		            <button class="btn btn-sm btn-danger" name="action" value="Delete Product"><i class="fa fa-trash"></i> </button> 
		            <!--		            <input type="submit" name="action" value="Delete Product"/>-->
		        </td>
		        <td class="text-right">
		            <button class="btn btn-sm btn-light" name="action" value="Update Cart"><i class="fa fa-refresh"></i> </button> 
		            <!--<input type="submit" name="action" value="Update Cart"/>-->
		        </td>
		    </tr>              
		</form>
	              </c:forEach>
	              <tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td>
		    <strong>Total : </strong>
		</td>
		<td class="text-right">
		    <strong>
		        <c:out value="${total} $"/>
		        <c:url var="add_more" value="MainController">
		            <c:param name="action" value="add_more"></c:param>                                      
		            <c:param name="search" value="${param.search}"></c:param>
		            <c:param name="productID" value="${phone.productID}"></c:param> 
		        </c:url>
		    </strong>
		</td>
	              </tr>
	              </tbody>
	          </table>
	      </c:if>
	  </div>
                </div>
            </div>
            <form action="MainController">
                <div class="col mb-2">
	  <div class="row">
	      <form action="MainController">
	      </form>
	      <div class="col-sm-12  col-md-6">
	          <button type="submit" class="btn btn-block btn-light" value="add_more" name="action"><a href="SearchProController?action=searchPro&search=">Continue Shopping</a></button>
	      </div>
	      <div class="col-sm-12 col-md-6 text-right">
	          <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
	      </div>
	  </div>
                </div>
            </form>
        </div>
    </body>
</html>
