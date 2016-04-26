/**
 * Created by Ken on 11/03/2016.
 */

var app = angular.module('BookStore', ['ngMaterial', 'ui.router']);

app.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('green')
        .accentPalette('orange');
});

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/newbooks');
    $stateProvider
        .state('newbooks', {
            url: "/newbooks",
            templateUrl: "/index/home/BookList.html"
        })
        .state('detail', {
            url: "/detail?bookid",
            templateUrl: "/index/book/ViewBook.html"
        })
        .state('category', {
            url: "/category?categoryid",
            templateUrl: "/index/home/BookList.html"
        })
        .state('search', {
            url: "/search?key",
            templateUrl: "/index/home/BookList.html"
        });
});