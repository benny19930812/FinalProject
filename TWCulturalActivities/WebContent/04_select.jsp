<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>模糊查詢</title>
    <style>
        /* .table{
            border:1;
        } */
    </style>
</head>
<body>
<form name="hello" action="04_Booking.jsp" method="GET">
	節目查詢
    <table border="1">
        <tr>
            <th>編號</th>
            <th>節目名稱</th>
            <th>場地</th>
            <th>日期</th>
            <th>購買</th>    
        </tr>

<%--使用JSTL 執行for loop ${show.no}取map內value --%>
        <c:forEach items="${key_list}" var="show" varStatus="idx">
        <tr>
				<td>${show.no}</td><td>${show.title}</td><td>${show.site}</td><td>${show.date}</td><td><input type=SUBMIT value="購買"></td>
			</tr>
		</c:forEach>

        
    </table>
</body>
</html>