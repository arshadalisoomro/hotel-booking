var bookControllers = angular.module('bookControllers', []);

bookControllers.controller('roomsCtrl', ['$scope', '$http',
function ($scope, $http, sharedService)
  {
	
	$http.get('http://localhost:8080/bookings/roomTypes.json').
	success(function(data)
	{		
		$scope.roomTypes = data;
	});
	
	$('#search').click(function(){
		var checkin = $('#start').val();
		var checkout = $('#end').val();
		var rooms = $('#rooms').val();
		var roomType = $( "select option:selected" ).attr('value');
		if(checkin != '' && checkout != '' && rooms!='' && roomType != '')
		{
			$.ajax({
				type: "GET",
				url: "http://localhost:8080/bookings/search.json",
				dataType: "json",
				data: {
					checkin: checkin,
					checkout: checkout,
					rooms: rooms,
					roomType: roomType
				},
				success: function (response){
	                //dataService.dataObj = response;
					sharedService.prepForBroadcast(response);
	            }
			});
		}
		else{
			alert("All fields need to be filled!");
		}
		
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

bookControllers.controller('testCtrl', ['$scope', '$http',
                                         function ($scope, $http, sharedService)
                                           {
	$scope.$on('handleBroadcast', function() {
        $scope.message = sharedService.message;
    });  
	alert($scope.message);
   }
  ]);