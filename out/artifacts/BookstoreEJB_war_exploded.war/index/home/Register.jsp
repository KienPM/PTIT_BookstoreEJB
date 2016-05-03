<%--
  Created by IntelliJ IDEA.
  User: Ken
  Date: 26/03/2016
  Time: 08:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="icon" href="/icons/ic_book.png">
        <title>Đăng ký</title>
        <link rel="stylesheet" type="text/css" href="/bower_components/angular-material/angular-material.min.css">
    </head>
    <body ng-app="Register" ng-controller="registerCtrl">

        <form name="loginForm">
            <md-toolbar>
                <div class="md-toolbar-tools md-whiteframe-5dp" layout="row" layout-align="center center">
                    <a href="/"><img src="/icons/logo.png" style="width: 175px; height: 50px"></a>

                    <h1 style="color:white; font-weight:bold">Đăng ký</h1>
                </div>
            </md-toolbar>
            <div layout="row" layout-align="center start">
                <div flex="30">
                    <md-input-container class="md-block">
                        <md-icon md-svg-src="/icons/ic_account_box_36px.svg"></md-icon>
                        <input ng-model="user.username" type="text" placeholder="Tên đăng nhập*" ng-required="true"
                               autofocus>
                    </md-input-container>

                    <md-input-container class="md-block">
                        <md-icon md-svg-src="/icons/ic_vpn_key_36px.svg"></md-icon>
                        <input name="password" ng-model="user.password" type="password" placeholder="Mật khẩu*"
                               ng-required="true">
                    </md-input-container>

                    <md-input-container class="md-block">
                        <md-icon md-svg-src="/icons/ic_vpn_key_36px.svg"></md-icon>
                        <input name="retypePassword" ng-model="retypePassword" type="password"
                               placeholder="Nhập lại mật khẩu"
                               ng-required="true">
                        <span ng-show="!isMatchPassword" style="color:red">Mật khẩu chưa khớp</span>
                    </md-input-container>

                    <md-input-container class="md-block">
                        <md-icon md-svg-src="/icons/ic_account_box_36px.svg"></md-icon>
                        <input ng-model="user.name" type="text" placeholder="Họ tên*" ng-required="true">
                    </md-input-container>

                    <md-input-container>
                        <label>Quốc tịch</label>
                        <md-select ng-model="user.nationality">
                            <md-option value="Việt Nam" selected="selected">Việt Nam</md-option>
                            <md-option value="Nước ngoài">Nước ngoài</md-option>
                        </md-select>
                    </md-input-container>

                    <md-input-container class="md-block">
                        <md-icon md-svg-src="/icons/ic_email_36px.svg"></md-icon>
                        <input ng-model="user.email" type="email" placeholder="Email*" ng-required="true">
                    </md-input-container>

                    <md-input-container class="md-block">
                        <md-icon md-svg-src="/icons/ic_phone_36px.svg"></md-icon>
                        <input ng-model="user.phone" type="text" placeholder="Số điện thoại*" ng-required="true">
                    </md-input-container>

                    <md-input-container class="md-block" flex>
                        <label>Địa chỉ*</label>
                        <md-icon md-svg-src="/icons/ic_location_36px.svg"></md-icon>
                        <input ng-model="user.address" type="text" placeholder="Xã/phường - Quận/huyện - Tỉnh/Thành phố"
                               ng-required="true">
                    </md-input-container>

                    <div layout="row" layout-align="center center">
                        <input type="submit" class="md-button md-raised md-primary md-hue-2" href="/Register"
                               value="Đăng ký"
                               ng-click="onSubmit()"/>
                    </div>
                </div>
            </div>

        </form>


        <script src="/bower_components/angular/angular.min.js"></script>
        <script src="/bower_components/angular-material/angular-material.min.js"></script>
        <script src="/bower_components/angular-animate/angular-animate.min.js"></script>
        <script src="/bower_components/angular-aria/angular-aria.min.js"></script>
        <script src="/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
        <script src="/index/home/RegisterCtrl.js"></script>

    </body>
</html>
