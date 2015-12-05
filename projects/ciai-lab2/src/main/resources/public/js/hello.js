var app = angular.module('hello', ['ngRoute', 'bookControllers']);

app.config(['$routeProvider',
            function($routeProvider) {
	$routeProvider.
	when('/getavailablerooms', {
		templateUrl: '/static/rooms-angular.html',
		controller: 'roomsCtrl'
	}).
	when('/chooseinfo', {
        templateUrl: 'static/form-angular.html',
        controller: 'infoCtrl'
    }).
	when('/', {
        templateUrl: 'static/welcome-angular.html',
        controller: 'welcomeCtrl'
    })
}]);