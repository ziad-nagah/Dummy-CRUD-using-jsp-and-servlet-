<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>ADD Details</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/add-item.css">

</head>
<body>
<%
boolean keep = (boolean)(session.getAttribute("keepIn") == null?false:session.getAttribute("keepIn"));
if(!keep){response.sendRedirect("UserController");}
 %>
<!-- partial:index.partial.html -->
<div class="container">
  <div class="text">
    Add Details
  </div>
  <form action="/test33/ItemController">
    <div class="form-row">
      <div class="input-data">
        <input type="hidden" required name="itemId" value="${itemId}">     
      </div>
    </div>
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="itemDetail">
        <div class="underline"></div>
        <label>Details</label>
      </div>
      
      <input type="hidden" required name="action" value="add-details">

    </div>
    <input type="submit" value="Add" class="button">
  </form>

  <p class="back">
    <a href="" >Back To Items</a>
  </p>
</div>
<!-- partial -->

</body>
</html>
