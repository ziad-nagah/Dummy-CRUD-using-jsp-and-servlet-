<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Log In</title>
  <link rel="stylesheet" href="style.css" />
</head>
<body>
<%
boolean keep;
if(session.getAttribute("keepIn") == null ){ 
	keep = false;}else{ keep = (boolean)session.getAttribute("keepIn"); }

if(keep){response.sendRedirect("ItemController");}
 %>
  <div class="card">
    <h2>Welcome</h2>

    <input type="radio" name="tab" id="tab-in" checked>
    <input type="radio" name="tab" id="tab-up">

    <div class="tab-switch">
      <label for="tab-in">Sign In</label>
      <label for="tab-up">Sign Up</label>
    </div>

    <div class="forms">
      <!-- Sign‑In -->
      <form  action = "/test33/UserController" id="form-in" class="login-form form-section">
        <div class="field">
          <label>Username</label>
          <input  type="text" required name="userName">
          <input type="hidden"  required name="action" value = "log-in">         
        </div>
        <div class="field">
          <label>Password</label>
          <input  type="password" required minlength="8" name="password">
        </div>
	  <div class="field">
	      <label for="check">Keep me Signed in</label>
          <input id="check" type="checkbox" class="check" checked required name="keepin">
        </div>
        <button type="submit" class="submit">Sign In</button>
      </form>

      <!-- Sign‑Up -->
      <form  action = "/test33/UserController" id="form-up" class="login-form form-section">
        <div class="field">
          <label>Username</label>
          <input  type="text" required name="userName">
          <input type="hidden"  required name="action" value = "sign-in">
        </div>
        <div class="field">
          <label>Password</label>
          <input  type="password" required minlength="8" name="password">
        </div>
        <button type="submit" class="submit">Sign Up</button>
      </form>
    </div>
  </div>
</body>
</html>
