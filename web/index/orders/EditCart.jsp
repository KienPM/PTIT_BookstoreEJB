<%@ page import="entity.person.CustomerMember" %>
<%@ page import="entity.orders.Cart" %>
<%@ page import="entity.orders.BookOrder" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 28/03/2016
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="icon" href="/icons/ic_book.png">
    <link rel="stylesheet" type="text/css" href="/bower_components/angular-material/angular-material.min.css">
    <link rel="stylesheet" type="text/css" href="/index/orders/Cart.css">
</head>
<body ng-app="EditCart" layout="column" ng-controller="editCartCtrl" ng-cloak

        <%
            CustomerMember customer = null;
            if (session.getAttribute("customer") != null) {
                customer = (CustomerMember) session.getAttribute("customer");
        %>
      ng-init="isLogedIn = true"
        <%
        } else {
        %>
      ng-init="isLogedIn = false"
        <%
            }
        %>
>
<div id="header">
    <md-toolbar>
        <div class="md-toolbar-tools md-whiteframe-5dp" layout="row" layout-align="space-around center">
            <a href="/"><img src="/icons/logo.png" style="width: 175px; height: 50px"></a>

            <div layout="row">
                <md-button class="md-raised" ng-click="showLoginDialog()" ng-show="!isLogedIn">Đăng nhập</md-button>
                <%
                    if (customer != null) {
                %>
                <h3 class="text-color-white"><%=customer.getUsername()%>
                </h3>
                <a class="md-button md-raised" href="/Logout">Đăng xuất</a>
                <%
                    }
                %>
            </div>
        </div>
    </md-toolbar>
</div>

<md-card>
    <form method="post" name="editCartForm">
        <md-content class="md-padding" layout="column" layout-align="center center">
            <table border="1px" align="left">
                <tr>
                    <th>Tên sách</th>
                    <th>Ảnh</th>
                    <th>Tác giả</th>
                    <th>Giá gốc</th>
                    <th>Giá bán</th>
                    <th>Số lượng</th>
                    <th>Bộ sách</th>
                    <th>Tổng tiền</th>
                    <th></th>
                </tr>
                <tr ng-repeat="bo in bookOrders track by $index">
                    <td>{{bo.book.title}}</td>
                    <td><img src="/imageBook/{{bo.book.image}}" width="35px" height="60px"/></td>
                    <td>{{bo.book.author.name}}</td>
                    <td>{{bo.book.originalPrice}}</td>
                    <td>{{bo.book.salePrice}}</td>
                    <td><input type="number" min="1" ng-model="quantities[$index]"></td>
                    <td>{{bo.book.bookSet.description}}</td>
                    <td>{{bo.book.salePrice * bo.quantity}}</td>
                </tr>
                <tr>
                    <td>Pay NOT SALE BOOK SET</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>{{totalPrice}}</td>
                </tr>
                <tr>
                    <td>Pay After SALE BOOK SET</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>{{saleBookSetPrice}}</td>
                </tr>
            </table>
        </md-content>

        <div layout="row" layout-align="center center">
            <md-button type="submit" class="md-raised md-accent md-hue-2 text-color-white"
                       ng-click="onClickUpdateCart()">
                Cập nhật giỏ hàng
            </md-button>
            <md-button type="submit" class="md-raised md-accent md-hue-2 text-color-white" ng-click="onClickSaveCart()">
                Lưu giỏ hàng
            </md-button>
            <md-button type="submit" class="md-raised md-accent md-hue-2 text-color-white" ng-click="onClickOrder()">
                Đặt hàng
            </md-button>
        </div>
    </form>
</md-card>

<script src="/bower_components/angular/angular.min.js"></script>
<script src="/bower_components/angular-material/angular-material.min.js"></script>
<script src="/bower_components/angular-animate/angular-animate.min.js"></script>
<script src="/bower_components/angular-aria/angular-aria.min.js"></script>
<script src="/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
<script src="/index/orders/EditCartCtrl.js"></script>
</body>
</html>
