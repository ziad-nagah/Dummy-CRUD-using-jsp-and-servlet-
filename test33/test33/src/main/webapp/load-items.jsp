<%@page import="java.util.ArrayList"%>
<%@page import="com.item.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Items</title>
  <link rel="stylesheet" href="style.css">
</head>
<body class="items-page">
<%
boolean keep = (boolean)(session.getAttribute("keepIn") == null?false:session.getAttribute("keepIn"));
if(!keep){response.sendRedirect("UserController");}
 %>
  <h1>Books</h1>

  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>TOTAL_NUMBER</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <%
        List<Item> items = (List<Item>) request.getAttribute("itemsData");
        %>
        <% if(!(items == null)){
        	for(Item item: items){
        %>
        <tr>
            <td><strong><%=item.getId() %></strong></td>
            <td><%=item.getName() %></td>
            <td><%=item.getPrice() %></td>
            <td><%=item.getTotalNumber()%></td>
            <td>
                <button type="button" class="btn"><a href='ItemController?action=load-item&id=<%=item.getId() %>'>Update</a></button>
                <button type="button" class="btn"><a href='ItemController?action=remove-item&id=<%=item.getId() %>'>Delete</a></button>
                <%boolean isDetailed = item.getDetail() == null; 
                if(isDetailed){%>
                <button type="button" class="btn"><a href='ItemController?action=load-details&id=<%=item.getId() %>'>Add Details</a></button>
                <%} else{%>
                <button type="button" class="btn"><a href='ItemController?action=show-details&id=<%=item.getId() %>'>showDetailes</a></button>
                <%} %>
            </td>
        </tr>
        <%}}else{%>
        <tr><td>no data added yet</td></tr><%}%>
    </tbody>
  </table>

  <div class="center">
    <button type="button" class="big-btn"><a href="add-item.html">Add Item</a></button>
  </div>
</body>
</html>

