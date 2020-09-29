<%@ page import="java.sql.*, java.util.*, java.text.*"%>
<%@ page InitialContext ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/xe");%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	

    <table border="1">
		<%

		%>
        <tr>
            <th>演出日期區間</th>
            <th>節目名稱</th>
            <th>場地</th>
            <th>購買</th>    
        </tr>
        <tr>
            <td>rs.getString(1)</td>
            <td>rs.getString(1)</td>
            <td>rs.getString(2)</td>
            <td>rs.getString(3)</td>
        </tr>
    </table>
</body>
</html>