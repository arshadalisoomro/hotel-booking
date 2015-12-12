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

app.factory('mySharedService', function($scope) {
    var sharedService = {};
    
    sharedService.message = [];

    sharedService.prepForBroadcast = function(msg) {
        this.message = msg;
        this.broadcastItem();
    };

    sharedService.broadcastItem = function() {
        $scope.$broadcast('handleBroadcast');
    };

    return sharedService;
});