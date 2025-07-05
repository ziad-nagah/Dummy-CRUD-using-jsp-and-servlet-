<%@page import="com.item.model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Update Item</title>
  <link rel="stylesheet" href="style.css">
</head>
<body class="form-page">
<%
boolean keep = (boolean)(session.getAttribute("keepIn") == null?false:session.getAttribute("keepIn"));
if(!keep){response.sendRedirect("UserController");}
 %>
  <h1><span class="gradient">Update Item</span></h1>
  <form action="/test33/ItemController">
  <input type="hidden" required name="action" value="update-item" >
  <input type="hidden" required name="itemId" value="${itemData.id}">
  <input type="text" required name="itemName"  value="${itemData.name}" placeholder="Name">
  <input type="text" required name="itemPrice" value="${itemData.price}" placeholder="Price">
  <input type="text" required name="itemTotalNumber" value="${itemData.totalNumber}" placeholder="Total Number">
  <% 
      boolean isDetailed = ((Item) request.getAttribute("itemData")).getDetail() == null;
      if(!isDetailed){ %>
        <input type="text" required name="itemDetail" value="${itemData.detail}" placeholder="description">
        <%} %>
  <button type="submit" class="btn-form">Update</button>
  <button class="btn-form">Back to Books</button>
</form>
</body>
</html>