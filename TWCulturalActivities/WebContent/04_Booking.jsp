<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
    <H1>訂票系統</H1>
    <table border="1">
        <tr>
            <td>全票</td>
            <td>TWD$1000</td>
            <td>
                <input type="button" value="-" name="minus" class="minus" id="minus">
                <!-- <P name="orderNum" id="orderNum" class="orderNum"></P> -->
                <input type="text" name="ordeNum" id="orderNum" class="orderNum" value="" >
                <input type="button" value="+" name="plus" class="plus" id="plus">
            </td>
        </tr>
        <tr>
            <td>半票</td>
            <td>TWD$500</td>
            <td>
                <input type="button" value="-" name="minus" class="minus" id="minus2">
                <input type="text" name="ordeNum" id="orderNum2" class="orderNum" value="" >
                <input type="button" value="+" name="plus" class="plus" id="plus2">
            </td>
        </tr>
        <tr>
       <td>總金額</td>
        <td >TWD$</td>
        <td name="total" id="total" class="total">0</td>
        </tr>
    </table>
        <input type="button" value="送出訂單" name="submit" class="submit" id="submit">
    <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>
    <script>
        //全票
        $(document).ready(function(){
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
        $("#total").text(count*parseInt(1000)+count2*parseInt(500))
        }) 
        $("#minus").click(function () {
        	//設定數量下限0
        	if (count >0) {
        		count--;
            } else if (count=0 ) {
            	count = 0;
            }
        $("#orderNum").val(count);
        $("#total").text(count*parseInt(1000)+count2*parseInt(500))
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
        $("#total").text(count*parseInt(1000)+count2*parseInt(500))
        }) 
        $("#minus2").click(function () {
        	if (count2 >0) {
        		count2--;
            } else if (count2=0 ) {
            	count2 = 0;
            }
        $("#orderNum2").val(count2);
        $("#total").text(count*parseInt(1000)+count2*parseInt(500)) 
        })  
    }) 
    //半票
    $(document).ready(function(){
    }) 
    </script>

</body>

</html>