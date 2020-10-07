<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>節目內容</title>
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
	
	 <form name="order" action="./04_Booking2.jsp " method="post">
	 
	<!-- 用param.取，相當於request.getParameter-->
	<c:set var="title" value="${param.title}" scope="session"/>
    <H1>確認張數</H1>
    節目名稱:<P>${title}</P>
    節目簡介:
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
            <td>
                <input type="button" value="-" name="minus" class="minus" id="minus">
                <!-- <P name="orderNum" id="orderNum" class="orderNum"></P> -->
                <input type="text" name="orderNum" id="orderNum" class="orderNum" value="" >
                <input type="button" value="+" name="plus" class="plus" id="plus">
            </td>

            <td name="price" class="price" id="price" >1000</td>
            <td>
			<input type="text" name="total" id="total" class="total"value="0" readonly="readonly" />
			</td>

            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>
        </tr>
        <tr>
            <td>${title}</td>
            <td>半票</td>
            <td>
                <input type="button" value="-" name="minus2" class="minus2" id="minus2">
                <!-- <P name="orderNum" id="orderNum" class="orderNum"></P> -->
                <input type="text" name="ordeNum2" id="orderNum2" class="orderNum" value="" >
                <input type="button" value="+" name="plus2" class="plus2" id="plus2">
            </td>
            <td name="price" class="price" id="price" >500</td>
               <td>
			<input type="text" name="total2" id="total2" class="total"value="0" readonly="readonly" />
			</td>
            <td ><input type="button" value="刪除" name="submit" class="submit" id="submit"></td>
        </tr>
        

    </table>
        <input type="submit" value="確認數量" name="submit" class="submit" id="submit">
        
    </form>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>
    <script>
        //全票
        $(document).ready(function(){
        	/* 價格顯示 */

        	/* $("select").change(function(){
        		  $("#price").text("500");
        		}); */

        	
        	var count =0 ;
        $("#orderNum").val(count);
        $("#plus").click(function () {
        	//設定數量上限為5
        	if (count < 5) {
        		count++;
            } else if (count=5 ) {
            	count = 5;
            }
        $("#orderNum").val(count);
        $("#total").val(count*parseInt(1000))
        }) 
        $("#minus").click(function () {
        	//設定數量下限0
        	if (count >0) {
        		count--;
            } else if (count=0 ) {
            	count = 0;
            }
        $("#orderNum").val(count);
        $("#total").val(count*parseInt(1000))
        return count;
        }) 
         var count2 = 0;
        $("#orderNum2").val(count2);
        $("#plus2").click(function () {
        	if (count2 < 5) {
        		count2++;
            } else if (count2=5 ) {
            	count2 = 5;
            }
        $("#orderNum2").val(count2);  
        $("#total2").val(count2*parseInt(500))
        }) 
        $("#minus2").click(function () {
        	if (count2 >0) {
        		count2--;
            } else if (count2=0 ) {
            	count2 = 0;
            }
        $("#orderNum2").val(count2);
        $("#total2").val(count2*parseInt(500)) 
        })  
    }) 
    //半票
    $(document).ready(function(){
    }) 
    </script>

</body>

</html>