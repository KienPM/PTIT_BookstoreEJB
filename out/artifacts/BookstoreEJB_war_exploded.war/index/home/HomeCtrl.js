/**
 * Created by Ken on 10/03/2016.
 */

app.controller('homeCtrl', function ($scope, $http, $location, $state, $stateParams, $mdDialog) {
    $scope.currentState = $state;
    $scope.isShowError = false;
    $scope.errorMessage = "Trang web hiện đang bảo trì, vui lòng quay lại sau!";

    getCategories();

    $scope.$watch('currentState.current', function (newValue) {
        $state.current = newValue;
        if ($state.includes('newbooks')) {
            getAllBooks();
        } else if ($state.includes('search')) {
            searchBook();
        }
    });

    function getCategories() {
        var req = {
            method: 'POST',
            url: '/GetCategories',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.categories = $scope.result[1];
                console.log($scope.categories);
            } else {
                $scope.isShowError = true;
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }

    function getAllBooks() {
        var req = {
            method: 'POST',
            url: '/GetList',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.books = $scope.result[1];
                console.log($scope.books);
            } else {
                $scope.isShowError = true;
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }

    $scope.viewBook = function (index) {
        $scope.book = $scope.books[index];
        $location.url('detail?bookid=' + $scope.book.id);
    }

    $scope.getBooksByCategory = function (index) {
        var req = {
            method: 'POST',
            url: '/GetBookByCategory',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }, params: {
                idCategory: index
            }
        };

        $http(req).then(function (response) {
            $location.url('category?id=' + index);
            //$state.go('category?id=' + index);
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.books = $scope.result[1];
                console.log($scope.books);
            } else {
                $scope.isShowError = true;
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }

    function searchBook() {
        var key = $stateParams.key;
        console.log('search: ' + key);
        var req = {
            method: 'POST',
            url: '/SearchBook',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }, params: {
                key: key
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.books = $scope.result[1];
                console.log($scope.books);
            } else {
                $scope.isShowError = true;
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }

    $scope.showLoginDialog = function (ev) {
        $mdDialog.show({
                controller: LoginDialogController,
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

    $scope.showCartDialog = function (ev) {
        $mdDialog.show({
                locals: {dataToPass: $scope.isLogedIn},
                controller: CartDialogController,
                templateUrl: '/index/orders/CartDialog.jsp',
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

    $scope.searchBook = function () {
        console.log('search: ' + $scope.key);
        $location.url('search?key=' + $scope.key);
        var req = {
            method: 'POST',
            url: '/SearchBook',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }, params: {
                key: $scope.key
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.books = $scope.result[1];
                console.log($scope.books);
            } else {
                $scope.isShowError = true;
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
        $scope.key = "";
    }
});

function LoginDialogController($scope, $http, $window) {
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

function CartDialogController($scope, $http, dataToPass) {
    $scope.isLogedIn = dataToPass;
    $scope.submitOrder = function () {
        if (!$scope.isLogedIn) {
            alert('Bạn phải đăng nhập để có thể đặt hàng!');
            return;
        }
        var req = {
            method: 'POST',
            url: '/Order',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
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
        ;
    }
}