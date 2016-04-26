<%@ page import="entity.person.CustomerMember" %><%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 10/03/2016
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Store</title>
    <link rel="icon" href="/icons/ic_book.png">
    <link rel="stylesheet" type="text/css" href="/bower_components/angular-material/angular-material.min.css">
    <link rel="stylesheet" type="text/css" href="/index/home/HomeCustomer.css">
</head>
<body ng-app="BookStore" layout="column" ng-controller="homeCtrl" ng-cloak

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
            <a href="/"><img src="icons/logo.png" style="width: 175px; height: 50px"></a>

            <div layout="row" layout-align="center center" class="search-box">
                <form class="form-wrapper">
                    <input type="text" placeholder="Tìm kiếm" ng-model="key">
                    <input type="image" src="/icons/ic_search_black_24px.svg" ng-click="searchBook()" alt="Submit">
                </form>
            </div>

            <div layout="row">
                <img src="/icons/ic_shopping_cart_white_36px.svg" ng-click="showCartDialog()" class="clickabble">
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

<div layout="row" flex>
    <div id="menu" layout="column" flex="20">
        <ul>
            <li ng-repeat="category in categories" ng-click="getBooksByCategory(category.id)">
                <img src="/icons/ic_keyboard_arrow_right_black_24px.svg" align="center">
                {{category.type}}
            </li>
        </ul>
    </div>

    <md-content id="content" layout="column" class="md-padding background-grey" flex ui-view>
    </md-content>
</div>

<script src="/bower_components/angular/angular.min.js"></script>
<script src="/bower_components/angular-material/angular-material.min.js"></script>
<script src="/bower_components/angular-animate/angular-animate.min.js"></script>
<script src="/bower_components/angular-aria/angular-aria.min.js"></script>
<script src="/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
<script src="/index/home/App.js"></script>
<script src="/index/home/HomeCtrl.js"></script>
<script src="/index/book/ViewBookCtrl.js"></script>
</body>
</html>
