var app = angular.module('shopping-list', ['ngRoute']);

app.config(function ($routeProvider, $httpProvider, $locationProvider) {
    // $locationProvider.hashPrefix(''); //removing '!' in address
    $locationProvider.html5Mode(true); //removing '#'

    $routeProvider.when('/',
        {
            templateUrl: 'parts/welcome.html',
            controller: 'welcome'
        }).when('/login',
        {
            templateUrl: 'parts/login.html',
            controller: 'login'
        });

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});

var WelcomeController = app.controller('welcome', function ($http) {
});