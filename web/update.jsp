<%-- 
    Document   : update
    Created on : May 13, 2021, 2:19:49 PM
    Author     : Khoa Nguyễn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
        <style type="text/css">
            @import url('https://fonts.googleapis.com/css?family=Montserrat');
            #body-row {
                margin-left: 0;
                margin-right: 0;
            }
            #sidebar-container {
                min-height: 77vh;
                background-color: #222222;
                padding: 0;
                /* flex: unset; */
            }
            .sidebar-expanded {
                width: 230px;
            }
            .sidebar-collapsed {
                width: 100px;
            }   
            #sidebar-container .list-group a {
                height: 50px;
                color: white;
                font-size: 25px
            }  
            #sidebar-container .list-group li.list-group-item {
                background-color: #222222;
            }
            #sidebar-container .list-group .sidebar-submenu a {
                height: 45px;
                padding-left: 30px;
            }
            .sidebar-submenu {
                font-size: 0.9rem;
            } 
            .sidebar-separator-title {
                background-color: #222222;
                height: 35px;
            }
            .sidebar-separator {
                background-color: #222222;
                height: 25px;
            }
            .logo-separator {
                background-color: #222222;
                height: 60px;
            }
            a.bg-dark {
                background-color: #222222 !important;
            }
            .updateForm input[type=text], .updateForm select,
            .updateForm input[type=number]{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .updateForm input[type=submit] {
                width: 100%;
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .updateForm input[type=submit]:hover {
                background-color: #45a049;
            }

            .updateForm div {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
            .col{
                background-color: cornsilk;
            }
        </style>

    </head>
    <body>
        <div class="container-fluid p-0">
            <div class="row" id="body-row">
                <div id="sidebar-container" class="sidebar-expanded d-none d-md-block">
                    <ul class="list-group">
                        <a href="#" class="bg-dark list-group-item list-group-item-action">
                            <div class="d-flex w-100 justify-content-start align-items-center">
                                <span class="fa fa-user fa-fw mr-3"></span>
                                <span class="menu-collapsed">Hi,
                                    <c:if test="${not empty  sessionScope.LOGIN_USER}">
                                        <span class="menu-collapsed">${sessionScope.LOGIN_USER.getName()}</span>
                                    </c:if>
                                </span>    
                            </div>
                        </a>       
                        <a href="#" class="bg-dark list-group-item list-group-item-action">
                            <div class="d-flex w-100 justify-content-start align-items-center">
                                <span class="fas fa-id-badge mr-4"></span>
                                <span class="menu-collapsed">Profile</span>    
                            </div>
                        </a>
                        <a href="#submenu2" data-toggle="collapse" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
                            <div class="d-flex w-100 justify-content-start align-items-center">
                                <span class="fa fa-tasks fa-fw mr-3"></span>
                                <span class="menu-collapsed">Categories</span>
                                <span class="submenu-icon ml-auto"></span>
                            </div>
                        </a>
                        <div id='submenu2' class="collapse sidebar-submenu">
                            <c:set var="listCate" value="${sessionScope.LISTCATE}"/>
                            <c:forEach items="${listCate}" var="o">
                                <li class="list-group-item text-white"><a href=MainController?action=searchByCate&cateID=${o.categoryID}>${o.categoryName}</a></li>
                                </c:forEach>

                        </div> 
                        <a href="#" class="bg-dark list-group-item list-group-item-action">
                            <div class="d-flex w-100 justify-content-start align-items-center">
                                <span class="fas fa-shopping-cart mr-3"></span>
                                <span class="menu-collapsed">View Cart</span>    
                            </div>
                        </a>

                        <c:if test="${not empty  sessionScope.LOGIN_USER}">
                            <a href="MainController?action=Logout" class="bg-dark list-group-item list-group-item-action">
                                <div class="d-flex w-100 justify-content-start align-items-center">
                                    <span class="fas fa-sign-out-alt mr-3"></span>
                                    <span class="menu-collapsed">Logout</span>    
                                </div>
                            </a>
                        </c:if>
                    </ul>
                </div>
                <div class="col">
                    <h1>
                        <nav class="navbar navbar-light bg-light justify-content-between">
                            <a class="navbar-brand" href="MainController?action=homePage">Menu</a>
                        </nav>
                    </h1>


                    <div class="col-12">
                        <c:set var="listCate" value="${sessionScope.LISTCATE}"/>
                        <c:set var="product" value="${requestScope.PRODUCTDTO}"/>
                        <div class="updateForm">
                            <form action="MainController">
                                <label for="proID">Product ID</label>
                                <input type="text" id="proID" name="productID" value="${product.productID}" readonly>


                                <label for="proName">Product Name</label>
                                <input type="text" id="proName" name="productName" value="${product.productName}" placeholder="Your product name..">


                                <label for="IMG">Product Image</label>
                                <input type="text" id="IMG" name="productImage" value="${product.productImg}" placeholder="Your product IMG..">


                                <label for="quantity">Product Quantity</label>
                                <input type="number" min="1" id="quantity" name="productQuantity" value="${product.quantity}" placeholder="Your product Quantity..">

                                <label for="price">Product Price</label>
                                <input type="number" min="1" id="price" name="productPrice" value="${product.price}" placeholder="Your product Price..">


                                <label for="cateID">Country</label>

                                <select id="cateID" name="categoriesID">
                                    <c:forEach var="dto" items="${listCate}">
                                        <c:if test="${product.categoryID eq dto.categoryID}">
                                            <option value="${dto.categoryID}" selected>${dto.categoryName}</option>
                                        </c:if>
                                        <c:if test="${product.categoryID ne dto.categoryID}">
                                            <option value="${dto.categoryID}">${dto.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="actionSearch" value="${param.actionSearch}" />
                                <input type="hidden" name="searchValue" value="${param.searchValue}" />
                                <input type="hidden" name="cateID" value="${param.cateID}" />
                                <input type="submit" name="action" value="updateProduct">
                                
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

