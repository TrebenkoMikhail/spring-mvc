angular.module('app', []).controller('indexController', function($scope,$http)) {
    const contextPath = 'http://localhost:8180/app';

    $scope.fillTable = function() {
    $http.get(contextPath + '/products')
        .then(function (response)) {
        $scope.ProductRepository = response.data;
        });
    };

    $scope.submitCreateNewProduct = function () {
    $http.post(contextPath + '/add', $scope.newProduct)
        .then(function (response)) {
            $scope.fillTable();
        });
};

$scope.deleteProductById = function(productId) {
    console.log('delTest');
    $http({
        url: contextPath + '/products' + productId,
        method: "DELETE"
    }).then(function(response) {
        $scope.fillTable();
    });
}