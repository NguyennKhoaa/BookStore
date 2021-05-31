<%-- 
    Document   : createDiscount
    Created on : May 21, 2021, 10:40:51 PM
    Author     : Khoa Nguyễn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Create Discount</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style type="text/css">

            .hehe{
                background-image: url('img/bg-01.jpg');
                width: 100%;
                min-height: 100vh;
                display: -webkit-box;
                display: -webkit-flex;
                display: -moz-box;
                display: -ms-flexbox;
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                align-items: center;
                padding: 15px;
                background-repeat: no-repeat;
                background-position: center;
                background-size: cover;
                position: relative;
                z-index: 1
            }
            .hehe:before{
                content: "";
                display: block;
                position: absolute;
                z-index: -1;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
                background-color: rgba(0,0,0,.65);
            }
            body{
                margin: 0;
                padding: 0;
                font-family: sans-serif;
                background: #34495e;
            }
            .box{
                width: 350px;
                padding: 40px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                background: black;
                text-align: center;
            }
            .box h1{
                color: white;
                text-transform: uppercase;
                font-weight: 500;
            }
            .box input[type = "text"],.box input[type = "password"],.box input[type = "number"]{
                border:0;
                background: none;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid #3498db;
                padding: 14px 10px;
                width: 200px;
                outline: none;
                color: white;
                border-radius: 24px;
                transition: 0.25s;
            }
            .box input[type = "text"]:focus,.box input[type = "password"]:focus{
                width: 280px;
                border-color: #2ecc71;
            }
            .box input[type = "submit"]{
                border:0;
                background: none;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid #2ecc71;
                padding: 14px 40px;
                outline: none;
                color: white;
                border-radius: 24px;
                transition: 0.25s;
                cursor: pointer;
            }
            .box input[type = "submit"]:hover{
                background: #2ecc71;
            }


        </style>

    </head>
    <body class="hehe">  
        <div class="box">
            <h1>Create Discount</h1>
            <form action="MainController" method="POST">

                <c:set var="err" value="${requestScope.DUPLICATE}"/>
                <input placeholder="DiscountID" type="text" name="discountID" value="${param.discountID}" required=""/>
                <c:if test="${not empty err}">
                    <font color="red">${err}</font>
                </c:if>

                <input placeholder="Discount Description" type="text" name="discountDescription" value="${param.discountDescription}" required=""/>
                <input placeholder="percentDiscount" type="number" min="1" max="100" name="percentDiscount" value="${param.percentDiscount}" required=""/>
                <input
                    type="submit"
                    name="action"
                    value="createNewDiscount"
                    />
            </form>
        </div>
    </body>
</html>
