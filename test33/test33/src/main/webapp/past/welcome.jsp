<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login & Sign Up</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<%
boolean keep = (boolean)(session.getAttribute("keepIn") == null?false:session.getAttribute("keepIn"));
if(keep){response.sendRedirect("UserController");}
 %>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <form class="sign-in-htm" action = "/test33/UserController">
                <div class="group">
                    <label for="user1" class="label">Username</label>
                    <input id="user1" type="text" class="input" required name="userName">
                    <input type="hidden"  required name="action" value = "log-in">
                </div>
                <div class="group">
                    <label for="pass2" class="label">Password</label>
                    <input id="pass2" type="password" class="input" data-type="password" required name="password">
                </div>
                <div class="group">
                    <input id="check" type="checkbox" class="check" checked required name="keepin">
                    <label for="check"><span class="icon"></span> Keep me Signed in</label>
                </div>
                <div class="group">
                    <input type="submit" class="button" value="log-in">
                </div>
                <div class="hr"></div>
            </form>
            <form class="sign-up-htm" action = "/test33/UserController">
                <div class="group">
                    <label for="user" class="label">Username</label>
                    <input id="user" type="text" class="input" required name="userName">
                    <input type="hidden"  required name="action" value = "sign-in">
                    
                </div>
                <div class="group">
                    <label for="pass" class="label">Password</label>
                    <input id="pass" type="password" class="input" data-type="password" required name="password">
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign Up">
                </div>
                <div class="hr"></div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
