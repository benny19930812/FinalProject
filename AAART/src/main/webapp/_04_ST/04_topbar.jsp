<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        .logo {
      
            border-radius: 10px;
            list-style-type: none;
            height:100px;
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
                       <a href="./04_index.jsp" target="" title="">首頁</a>
                       
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
                        <a href="./04_Booking2.jsp" target="" title="">購物車</a>
                    </li>
                    <li id="signup" class="nav2">
                        註冊
                    </li>
                    <li id="login" class="nav2">
                        會員登入
                    </li>
                </ul>
            </nav>

        </header><br>
</body>
</html>