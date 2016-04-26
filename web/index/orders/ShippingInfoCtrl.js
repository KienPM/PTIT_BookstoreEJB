/**
 * Created by Ken on 05/04/2016.
 */
var app = angular.module('ShippingInfor', ['ngMaterial']);

app.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('green')
        .accentPalette('orange');
});

app.controller('shippingInforCtrl', function ($scope) {

});
