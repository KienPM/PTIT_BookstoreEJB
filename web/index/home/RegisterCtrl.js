/**
 * Created by Ken on 26/03/2016.
 */
var app = angular.module('Register', ['ngMaterial']);

app.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('green')
        .accentPalette('orange');
});

app.controller('registerCtrl', function ($scope, $http, $window) {
    $scope.user = {};
    $scope.isMatchPassword = true;
    $scope.nations = ['Việt Nam', 'Khác'];

    var isVailid = function () {
        if ($scope.user.username == null) {
            console.log('block 1');
            return false;
        }
        if ($scope.user.password == null) {
            console.log('block 2');
            return false;
        }
        if ($scope.user.password != $scope.retypePassword) {
            $scope.isMatchPassword = false;
            console.log('block 3');
            $window.scrollTo(0, 0);
            return false;
        }
        if ($scope.user.name == null) {
            console.log('block 4');
            return false;
        }
        if ($scope.user.email == null) {
            console.log('block 5');
            return false;
        }
        if ($scope.user.phone == null) {
            console.log('block 6');
            return false;
        }
        if ($scope.user.address == null) {
            console.log('block 7');
            return false;
        }
        return true;
    }

    $scope.onSubmit = function () {
        if (!isVailid()) {
            return;
        }
        console.log('foo');
        console.log($scope.user);
        var req = {
            method: 'POST',
            url: '/Register',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            }, params: {
                user: $scope.user
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.isLogedIn = true;
                $window.location.href = '/';
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