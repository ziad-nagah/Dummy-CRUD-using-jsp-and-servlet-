<%@page import="com.item.model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>update Item</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/add-item.css">

</head>
<body>
<%
boolean keep = (boolean)(session.getAttribute("keepIn") == null?false:session.getAttribute("keepIn"));
if(!keep){response.sendRedirect("UserController");}
 %><!-- partial:index.partial.html -->
<div class="container">
  <div class="text">
    Update Item
  </div>
  <form action="/test33/ItemController">
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="itemName"  value="${itemData.name}">
        <div class="underline"></div>
        <label>Name</label>
      </div>
      <div class="input-data">
        <input type="text" required name="itemPrice" value="${itemData.price}">
        <div class="underline"></div>
        <label>PRICE</label>
      </div>
    </div>
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="itemTotalNumber" value="${itemData.totalNumber}">
        <div class="underline"></div>
        <label>TOTAL_NUMBER</label>
      </div>
      <% 
      boolean isDetailed = ((Item) request.getAttribute("itemData")).getDetail() == null;
      if(!isDetailed){ %>
      <div class="input-data">
        <input type="text" required name="itemDetail" value="${itemData.detail}">
        <div class="underline"></div>
        <label>Description</label>
      </div>
      <%} %>
      
      <input type="hidden" required name="action" value="update-item">
       <input type="hidden" required name="itemId" value="${itemData.id}">
    </div>
    <input type="submit" value="Update" class="button">
  </form>

  <p class="back">
    <a href="" >Back To Items</a>
  </p>
</div>
<!-- partial -->

</body>
</html>