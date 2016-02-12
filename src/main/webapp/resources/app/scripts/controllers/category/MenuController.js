define(['app'], function (app) {
	app.factory('MenusFactory', ['$resource', function($resource) {
		return $resource("menu", {}, {
			query : {
				method : 'GET',
				isArray : true
			}			
		});
	}]);
	
	app.factory('MenuFactorySave', ['$resource', function($resource) {
		return $resource("menu/novo", {}, {
			save : {
				method : 'POST',
			}			
		});
	}]);
	
	app.factory('MenuFactory',['$resource', function($resource) {
		return $resource("menu/:id", {}, {
			show : {
				method : 'GET'
			},
			update : {
				method : 'PUT',
				params : {
					id : '@id'
				}
			},
			remove : {
				method : 'DELETE',
				params : {
					id : '@id'
				}
			}
		});
	}]);
	
	app.controller("menusController",  ['$scope', '$rootScope', 'MenusFactory', function($rootScope, $scope, MenusFactory) {
		$scope.title = 'Categorias';
		$scope.menus = MenusFactory.query();		
	}]);
	
	
	app.controller("menuController", ['$scope', '$rootScope', '$location', '$routeParams',  'MenuFactory', function($rootScope, $scope,
			$location, $routeParams, MenuFactory) {					
		
		MenuFactory.show({
			id : $routeParams.menuId
		}, function(data){
			if (data.id) {
				$scope.menu = data;				
			} else {
				console.error("No user with id:" + $routeParams.menuId);
				$location.path("/menu");
			}
		}, function(data){
			console.error(data);
		});
		
		$scope.update = function(menu) {
			MenuFactory.update($scope.menu, function(data) {
				delete $scope.error;
				$location.path("/menu");
			}, function(data) {
				$scope.error = "There was an error updating menu!";
			});
		};
		
		$scope.remove = function(category) {
			CategoryFactory.remove(category, function() {
				$location.path("/menu");
			});
		};
		
		$scope.viewCategorys = function(){
			$location.path("/menu");
		};
	}]);
	
	app.controller("menuCreateController",  ['$scope', '$rootScope', 'MenuFactorySave', '$location', 
	                                         	function($rootScope, $scope, MenuFactorySave, $location) {
		$scope.title = 'Nova Categoria';
		$scope.newCategory = {};
		
		$scope.save = function() {
			CategoryFactorySave.save($scope.newCategory, function(data) {
				$location.path("/menu");
			}, function(data) {
				$scope.error = "There was an error save category!";
			});		
		};			
	}]);
	
});