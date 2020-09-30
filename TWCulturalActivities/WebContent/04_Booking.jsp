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
        <td ></td>
        <td name="total" id="total" class="total">0</td>
        </tr>
    </table>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>
    <script>
        //全票
        $(document).ready(function(){
        var count =0 ;
        $("#orderNum").val(count);
        $("#plus").click(function () {
            count=count+ 1;
        $("#orderNum").val(count);
        $("#total").text("TWD$"+count*parseInt(1000))
        }) 
        $("#minus").click(function () {
            count=count- 1;
        $("#orderNum").val(count);
        $("#total").text("TWD$"+count*parseInt(-1000))
        }) 
        var count2 = 0;
        $("#orderNum2").val(count);
        $("#plus2").click(function () {
            count2=count2+ 1;
        $("#orderNum2").val(count);  
        $("#total").text("TWD$"+count*parseInt(1000)+count2*parseInt(500))
        }) 
        $("#minus2").click(function () {
            count2=count2- 1;
        $("#orderNum2").val(count);
        $("#total").text("TWD$"+count*parseInt(-1000)+count2*parseInt(-500))
        }) 
    }) 
    //半票
    $(document).ready(function(){
    }) 
    </script>

</body>

</html>