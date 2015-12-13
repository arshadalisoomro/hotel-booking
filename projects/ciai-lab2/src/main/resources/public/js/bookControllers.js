var bookControllers = angular.module('bookControllers', []);

bookControllers.controller('roomsCtrl', ['$scope', '$http','$compile',
function ($scope, $http, $compile)
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
					alert(response);
					//$scope1 = $scope.$new(); 
					$scope.rooms_available = response;
					alert($scope.rooms_available);
					
					var html = "<table class=table>"+
							"<tr>"+
							"<th>Hotel</th>"+
							"<th>Room Type</th>"+
							"<th>Occupancy</th>"+
							"<th>Price</th>"+
							"<th></th>"+
						"</tr>"+
						"<tr ng-repeat='room in rooms_available'>"+
							"<td>{{room.hotel.name}}</td>"+
							"<td>{{room.type.description}}</td>"+
							"<td>{{room.type.occupancy}}</td>"+
							"<td>{{room.price}} €/night</td>"+
							"<td><a ng-click='bookFunction(room.hotel.id)' class='btn btn-default'>Book a room</a></td>"+
						"</tr>"+
					"</table>";
					
					var linkingFunction = $compile(html);
					var elem = linkingFunction($scope);
					$('#main').append(elem);
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
