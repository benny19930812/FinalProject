<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
        .topbar {
            background-color: #1B9AAA;
            height: 60px;
            margin: 0px;
            padding: 0px;
        }

        .nav{
            background-color: #DDDBCB;
            float: left;
            color: #050505;        
            border-radius: 10px;
            list-style-type: none;
            font-size: 30px;
            margin: 10px;
            font-family: Microsoft JhengHei;
            
            
        }
        .nav2{
            background-color: #DDDBCB;
            float: right;
            color: #050505;        
            border-radius: 10px;
            list-style-type: none;
            font-size: 30px;
            margin: 10px;
            font-family: Microsoft JhengHei;
        }

        
        </style>
<body>

<header id="topbar" class="topbar">
            <nav>
                  <ul >
                    <li id="index"" class=" nav">
                       <a href="<c:url value='/_04_ST/04_index.jsp'/>" target="" title="">首頁</a>
                       
                    </li>
                    <li id="category2" class="nav">
                       分類
                    </li>
                    <li id="order" class="nav">
                       訂單
                    </li>
                </ul>
                <ul>
                    <li id="cart"" class=" nav2">
                    	<a href="<c:url value='/_04_ST/04_Booking3.jsp'/>" target="" title="">購物車</a>
                    </li>
                    <li id="login" class="nav2">
                        <a href="<c:url value='/_04_register/register.jsp'/>" target="" title="">註冊</a>
                    </li>
                    <li id="signup" class="nav2">
                        <a href="<c:url value='/_04_login/login.jsp'/>" target="" title="">登入</a>
                        
                    </li>
                </ul>
            </nav>
        </header><br>
<!-- bootstrap匯入       -->
<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script> -->
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script> -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous"> -->
        
</body>
</html>