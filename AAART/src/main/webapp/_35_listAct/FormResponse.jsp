<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
   <HEAD>
      <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8"/>
      <TITLE>Activity Category List</TITLE>
      <style>
      	table, td {
      		border: 1px solid navy;
      	}
      </style>
   </HEAD>
   <BODY BGCOLOR="#FDF5E6">
   <H1>Activity Category List</H1>
   <%@ page import ="java.util.ArrayList" %>
   <%@ page import ="java.util.List" %>
   <%@page import="_35_init.MainTable"%>
   <% ArrayList<MainTable> list = (ArrayList)request.getAttribute("queryResults");
  		 String str = (String)request.getAttribute("queryCategory");%>
  		 <H2><%=str %></H2>
		<%for (MainTable item: list) {%>
		<table>
		<td><%=item.getNo() %></td>
		<td><%=item.getTitle() %></td>
		<td><%=item.getLocation() %></td>
		<td><%=item.getPrice() %></td><br>
		</table>

	<% }%>

   </BODY>
</HTML>