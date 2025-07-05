<%@page import="com.user.controller.UserController.Log"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>oooops</title>
  <link rel="stylesheet" href="style.css">

  
</head>

<body class="form-page">
<% Log log = (Log) request.getAttribute("log"); %>
  <h1><span class="gradient"><%= log.getName() %></span></h1>

  <form action="/test33/UserController">
    <p>
       <%= log.getMessage() %>
    </p>

    <button type="submit" class="btn-form">Go Back</button>
  </form>
</body>
</html>
