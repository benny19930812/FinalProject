<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("UTF-8");%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>e確認訂單資訊</title>
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


	<jsp:include page="/_04_ST/04_topbar.jsp" />
<%-- <c:set var="cartlist" value="${cartlist}"scope="session"/> --%>
    <H1>送出訂單</H1>
    <table border="1">
        


      <table border="1">  
        
        <tr>
            <td>節目名稱</td>
            <td>票種</td>
            <td>數量</td>
            <td>價格</td>
            <td>總價</td>
            <td>操作</td>
        </tr>
        
        <%--使用JSTL 執行for loop ${show.no}取map內value --%>
        <c:forEach items="${cartlist}" var="show" varStatus="idx">
        <tr>
       <!-- 傳送訂單資訊 -->
       <form name="order" action="./04_Booking.jsp" method="get">
		<tr>
            <td>${show.title}</td>
            <td>全票</td>
            <td>${show.adultnum}</td>
            <td name="price" class="price" id="price" >1000</td>
            <td name="total1" id="total1" class="total1">${show.total1}</td>
            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>
         </tr>
         <tr>
            <td>${show.title}</td>
            <td>半票</td>
            <td>${show.halfnum}</td>
            <td name="price" class="price" id="price" >500</td>
            <td name="total2" id="total2" class="total2">${show.total2}</td>
            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>

        </tr>
			</form>
			
			
		</c:forEach>
<tr><td>總計</td><td></td><td></td><td></td><td><input type="text" name="total3" id="total3" class="total3"value="0" readonly="readonly" /></td><tr>
   </table>        
         <form name="order" action="<c:url value='/_04_ShopCart/ClearCart'/>" method="POST">
          <input type="submit" value="全部清除" name="clear" class="clear" id="clear"> 
    	 </form>
          <input type="submit" value="送出訂單" name="1" class="1" id="1">  
         
    
<!-- <script src="js\jquery-3.5.1.min.js"></script> -->
 <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>

    <script>

    $("#1").click(function () {
    	if (confirm("再次確認訂單內容 ? ")) {
//     		window.location ="./_04_Orderlist/OrderlistServlet" 
    		window.location ="<c:url value='/_04_Orderlist/OrderlistServlet'/>" 
    	} else {
    		return false;
    	}
    	
    })

    </script>

</body>

</html>