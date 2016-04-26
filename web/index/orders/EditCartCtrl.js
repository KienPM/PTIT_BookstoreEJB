/**
 * Created by Ken on 15/03/2016.
 */
var app = angular.module('EditCart', ['ngMaterial']);

app.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('green')
        .accentPalette('orange');
});

app.controller('editCartCtrl', function ($scope, $http, $mdDialog) {
    $scope.totalPrice = 0;
    $scope.saleBookSetPrice = 0;
    $scope.quantities = [];

    getBookOrders();
    function getBookOrders() {
        var req = {
            method: 'POST',
            url: '/GetCart',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.bookOrders = $scope.result[1];
                console.log($scope.bookOrders);
                calculate();
            } else {
                $scope.errorMessage = $scope.result[1];
                $scope.isShowError = true;
                console.log($scope.errorMessage);
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    };

    function calculate() {
        var numOfBookSet = 0;
        var s = '';
        for (var i = 0; i < $scope.bookOrders.length; ++i) {
            $scope.totalPrice += parseFloat($scope.bookOrders[i].book.salePrice) * $scope.bookOrders[i].quantity;
            $scope.quantities[i] = $scope.bookOrders[i].quantity;
            if (s.indexOf($scope.bookOrders[i].book.bookSet.description) != -1) {
                ++numOfBookSet;
            } else {
                s += $scope.bookOrders[i].book.bookSet.description;
            }
        }
        $scope.saleBookSetPrice = $scope.totalPrice - numOfBookSet * 10000;
    }

    $scope.showLoginDialog = function (ev) {
        $mdDialog.show({
                controller: DialogController,
                templateUrl: '/index/home/LoginDialog.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose: true,
                fullscreen: false
            })
            .then(function (answer) {
//                $scope.status = 'You said the information was "' + answer + '".';
            }, function () {
//                $scope.status = 'You cancelled the dialog.';
            });
    };

    $scope.onClickUpdateCart = function () {
        if (!$scope.editCartForm.$valid) {
            console.log('invalid');
            return;
        }
        console.log($scope.quantities);
        var req = {
            method: 'POST',
            url: '/UpdateCart',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            params: {
                quantities: $scope.quantities
            }
        };

        $http(req);
    }

    $scope.onClickSaveCart = function () {
        if (!$scope.isLogedIn) {
            $scope.showLoginDialog();
            return;
        }
        if (!$scope.editCartForm.$valid) {
            console.log('invalid');
            return;
        }
        var req = {
            method: 'POST',
            url: '/SaveCart',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            params: {
                quantities: $scope.quantities
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                alert('Đã lưu giỏ hàng của bạn!');
            } else {
                $scope.errorMessage = $scope.result[1];
                $scope.isShowError = true;
                console.log($scope.errorMessage);
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }

    $scope.onClickOrder = function () {
        if (!$scope.isLogedIn) {
            $scope.showLoginDialog();
            return;
        }
        if (!$scope.editCartForm.$valid) {
            console.log('invalid');
            return;
        }

        var req = {
            method: 'POST',
            url: '/Order',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            params: {
                quantities: $scope.quantities
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                window.location = '/index/orders/ShippingInfor.jsp';
            } else {
                $scope.errorMessage = $scope.result[1];
                $scope.isShowError = true;
                console.log($scope.errorMessage);
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }
});

function DialogController($scope, $http, $window) {
    $scope.onClickLogin = function () {
        var req = {
            method: 'POST',
            url: '/CustomerLogin',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }, params: {
                username: $scope.user.username,
                password: $scope.user.password
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.isLogedIn = true;
                $window.location.reload();
            } else {
                $scope.errorMessage = $scope.result[1];
                $scope.isShowError = true;
                console.log($scope.errorMessage);
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }
}