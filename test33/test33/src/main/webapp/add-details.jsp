<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Description</title>
  <link rel="stylesheet" href="style.css">

  
</head>

<body class="form-page">
<%
boolean keep = (boolean)(session.getAttribute("keepIn") == null?false:session.getAttribute("keepIn"));
if(!keep){response.sendRedirect("UserController");}
 %>
  <h1><span class="gradient">Add Description</span></h1>

  <form action="/test33/ItemController">
    <textarea name="description" placeholder="Enter description…" required name="itemDetail"></textarea>
    <input type="hidden" required name="itemId" value="${itemId}">     
	<input type="hidden" required name="action" value="add-details">
    <button type="submit" class="btn-form">Add Description</button>
    <button type="button" class="btn-form">Back to Items</button>
  </form>
</body>
</html>
