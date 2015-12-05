var bookControllers = angular.module('bookControllers', []);

bookControllers.controller('roomsCtrl', ['$scope', '$http',
function ($scope, $http)
  {
	$http.get('http://localhost:8080/bookings/search.json').
	success(function(data)
	{
		//console.log(data);
		$scope.rooms_available = data;
	});
	
	$scope.bookFunction = function(hotelId)
	{
		$http.get('http://localhost:8080/bookings/new/' + hotelId + '.json').
		success(function(data)
		{
			console.log(data);
			$scope.booking = data;
		});
	}
  }
]);

bookControllers.controller('welcomeCtrl', ['$scope', '$http',
 function ($scope, $http)
 {
	$http.get('http://localhost:8080/hotels.json').
	success(function(data)
	{
		$scope.hotels = data;
	});
	
	$scope.range = function(min, max, step){
	    step = step || 1;
	    var input = [];
	    for (var i = min; i <= max; i += step) input.push(i);
	    return input;
	  };
 }
]);

bookControllers.controller('infoCtrl', ['$scope', '$http',
   function ($scope, $http)
   {

   }
  ]);