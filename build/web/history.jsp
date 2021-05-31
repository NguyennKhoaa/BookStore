<%-- 
    Document   : history
    Created on : May 16, 2021, 12:15:29 PM
    Author     : Khoa Nguyễn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Customer Page</title>
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
            .menu-collapsed:hover{
                color: #f79320;
            }
            #sidebar-container .list-group .sidebar-submenu a:hover{
                color: #f79320;
                text-decoration: none;
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
                                <span class="menu-collapsed mr-3">View Cart</span> 
                                <span id="quantityCart"></span>
                            </div>
                        </a>
                        <a href="MainController?action=historyPage" class="bg-dark list-group-item list-group-item-action">
                            <div class="d-flex w-100 justify-content-start align-items-center">
                                <span class="fas fa-history mr-3"></span>
                                <span class="menu-collapsed mr-3">History</span>    
                                <span id="quantityCart"></span>
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
                        <a class="navbar-brand" href="MainController?action=homePage">History</a>
                    </h1>

                    <c:set var="listOrder" value="${requestScope.cartHistory}"/>

                    <c:if test="${empty listOrder}">
                        <h1 style="text-align: center">History Cart Empty Please Buy Product</h1>
                    </c:if>

                    <c:if test="${not empty listOrder}">
                        <c:set var="listOrderDetail" value="${requestScope.cartDetail}"/>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">ID Order</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Detail</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="dto" items="${listOrder}">
                                    <tr>
                                        <td>${dto.orderID}</td>
                                        <td>${dto.userID}</td>
                                        <td>${dto.dateBuy}</td>
                                        <td>${dto.totalPrice}</td>
                                        <td>
                                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter${dto.orderID}">
                                                Detail
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <c:forEach var="dto" items="${listOrder}">
                            <div class="modal fade" id="exampleModalCenter${dto.orderID}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-dark">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">#</th>
                                                        <th scope="col">Order ID</th>
                                                        <th scope="col">Product ID</th>

                                                        <th scope="col">Price</th>
                                                        <th scope="col">Quantity</th>
                                                        <th scope="col">Total Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="detail" items="${listOrderDetail}">
                                                        <c:if test="${dto.orderID eq detail.key}">

                                                            <c:forEach var="listDetail" items="${detail.value}" varStatus="counter">
                                                                <tr>
                                                                    <th scope="row">${counter.count}</th>
                                                                    <td>${listDetail.orderID}</td>
                                                                    <td>${listDetail.productID}</td>
                                                                    <td>${listDetail.price}</td>
                                                                    <td>${listDetail.quantity}</td>
                                                                    <td>${listDetail.quantity * listDetail.price}
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>

                                                        </c:if>
                                                    </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
        <c:set var="map" value="${sessionScope.CART.cartProduct}"/>
        <script type="text/javascript">
            document.getElementById("quantityCart").textContent =${map.size()};
        </script>
        <%@include file="footer.jsp" %>

    </body>   

</html>
