<%@ page import="entity.person.CustomerMember" %><%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 05/04/2016
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Địa chỉ giao hàng</title>
    <link rel="stylesheet" type="text/css" href="/bower_components/angular-material/angular-material.min.css">
</head>
<body ng-app="ShippingInfor" layout="column" ng-controller="shippingInforCtrl" ng-cloak

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
                <h3 style="color:white"><%=customer.getUsername()%>
                </h3>
                <a class="md-button md-raised" href="/Logout">Đăng xuất</a>
                <%
                    }
                %>
            </div>
        </div>
    </md-toolbar>

    <md-card class="md-padding" layout="column" layout-align="start center">
        <form method="post" action="/SetShippingInfo">
            <table>
                <tr>
                    <td>Số nhà</td>
                    <td><input type="text" name="num" required></td>
                </tr>
                <tr>
                    <td>Xã/Phường</td>
                    <td><input type="text" name="ward" required></td>
                </tr>
                <tr>
                    <td>Quận/Huyện</td>
                    <td><input type="text" name="district" required></td>
                </tr>
                <tr>
                    <td>Tỉnh/Thành phố</td>
                    <td><input type="text" name="city" required></td>
                </tr>
            </table>
            <div layout="row" layout-align="center center">
                <md-button type="submit" class="md-raised md-primary md-hue-2">OK</md-button>
            </div>
        </form>
    </md-card>
</div>

<script src="/bower_components/angular/angular.min.js"></script>
<script src="/bower_components/angular-material/angular-material.min.js"></script>
<script src="/bower_components/angular-animate/angular-animate.min.js"></script>
<script src="/bower_components/angular-aria/angular-aria.min.js"></script>
<script src="/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
<script src="/index/orders/ShippingInfoCtrl.js"></script>
</body>
</html>
