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
            <th>�t�X����϶�</th>
            <th>�`�ئW��</th>
            <th>���a</th>
            <th>�ʶR</th>    
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