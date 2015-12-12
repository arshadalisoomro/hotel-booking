var app = angular.module('hello', ['ngRoute', 'bookControllers']);

app.config(['$routeProvider',
            function($routeProvider) {
	$routeProvider.
	when('/getavailablerooms', {
		templateUrl: '/static/rooms-angular.html',
		controller: 'testCtrl'
	}).
	when('/chooseinfo', {
        templateUrl: 'static/form-angular.html',
        controller: 'roomsCtrl'
    }).
	when('/', {
        templateUrl: 'static/welcome-angular.html',
        controller: 'welcomeCtrl'
    })
}]);

app.factory('myService', function() {
	 var savedData = [];
	 
	 function set(data) {
	   savedData = data;
	 }
	 
	 function get() {
	  return savedData;
	 }

	 return {
	  set: set,
	  get: get
	 }

	});