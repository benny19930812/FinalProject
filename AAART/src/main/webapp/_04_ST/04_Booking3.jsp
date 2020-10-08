<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>確認訂單資訊</title>
    <style>
        td {
            width: 100px;
        }

        .orderNum {
            width: 30px;
        }
    </style>
</head>

<body>
<form name="order2" action="<c:url value='/_04_Orderlist/OrderlistServlet'/> " method="get">

	<jsp:include page="/_04_ST/04_topbar.jsp" />
<c:set var="name" value="${param.name}" scope="session"/> 
<c:set var="email" value="${param.email}" scope="session"/> 
<c:set var="tel" value="${param.tel}" scope="session"/> 
<c:set var="add" value="${param.add}" scope="session"/> 
    <H1>送出訂單</H1>
    <table border="1">
        
        <tr>
            <td>訂購人姓名
            </td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>電子郵件
            </td>
            <td>
             ${email}
             </td>
        </tr>
        <tr>
            <td>電話
            </td>
            <td>
            
             ${tel}
            </td>
        </tr>
        <tr>
            <td>地址
            </td>
            <td>
             ${add}
            </td>
        </tr>
     </table><br><br> <br>  

      <table border="1">  
        
        <tr>
            <td>節目名稱</td>
            <td>票種</td>
            <td>數量</td>
            <td>價格</td>
            <td>總價</td>
            <td>操作</td>
        </tr>
        <tr>
            <td>${title}</td>
            <td>全票</td>
            <td>${adultnum}</td>
            <td name="price" class="price" id="price" >1000</td>
            <td name="total" id="total" class="total">${total}</td>
            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>
        </tr>
        <tr>
            <td>${title}</td>
            <td>半票</td>
            <td>${halfnum}</td>
            <td name="price" class="price" id="price" >500</td>
            <td name="total2" id="total2" class="total2">${total2}</td>
            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>
        </tr>
        

    </table><br>
        <input type="submit" value="送出訂單" name="submit" class="submit" id="submit">
    </form>
    
<script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>
    <script>
       
    </script>

</body>

</html>