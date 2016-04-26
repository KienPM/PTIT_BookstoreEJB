/**
 * Created by Ken on 15/03/2016.
 */
app.controller('viewBookCtrl', function ($scope, $http, $location, $stateParams, $window) {
    var bookid = $stateParams.bookid;
    var loadBook = function () {
        var req = {
            method: 'POST',
            url: '/ViewBook',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            params: {
                idbook: bookid
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            if ($scope.result[0] === "success") {
                $scope.isShowError = false;
                $scope.book = $scope.result[1];
                console.log($scope.book);
            } else {
                $scope.isShowError = true;
            }
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    };

    loadBook();

    $scope.addToCart = function () {
        var req = {
            method: 'POST',
            url: '/AddToCart',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            params: {
                idbook: bookid
            }
        };

        $http(req).then(function (response) {
            $scope.result = response.data;
            console.log($scope.result[0]);
            $window.location.reload();
            if ($scope.result[0] === "success") {
                alert('Đã thêm vào giỏ hàng của bạn!');
            }
            $scope.isShowError = $scope.result[0] !== "success";
        }, function (response) {
            console.log('fail');
            console.log(response);
        });
    }
});