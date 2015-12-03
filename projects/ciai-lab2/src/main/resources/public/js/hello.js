function Hotels($scope, $http) {
    $http.get('http://localhost:8080/hotels.json').
        success(function(data) {
        	console.log(data);
            $scope.hotels = data;
        });
}