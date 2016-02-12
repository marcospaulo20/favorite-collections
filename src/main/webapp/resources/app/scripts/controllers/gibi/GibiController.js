define(['app'], function (app) {
	app.factory('GibisFactory', ['$resource', function($resource) {
		return $resource("gibi", {}, {
			getAll : {
				method : 'GET',
				params: {},
				isArray : true
			}			
		});
	}]);
		
	app.controller("GibisController",  ['$scope', '$rootScope', 'GibisFactory', function($rootScope, $scope, GibisFactory) {
		$scope.title = 'Gibis';
		$scope.gibis = GibisFactory.getAll();		
	}]);
	
	app.factory('GibiFactory', ['$resource', function($resource) {
		return $resource("gibi/:id", {}, {
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
	
	app.controller("gibiController", ['$scope', '$rootScope', '$location', '$routeParams', '$mdMedia', '$mdDialog', '$mdMedia', 'GibiFactory',
	                                  function($scope, $rootScope, $location, $routeParams, $mdMedia, $mdDialog, $mdMedia, GibiFactory) {
		
		GibiFactory.show({
			id : $routeParams.gibiId			
		}, function(data) {
			if(data.id) {
				$scope.gibi = data;
				$scope.title = 'Gibi ' + data.name + '!';
			} else {
				console.error("No gibi with id: " + $routeParams.gibiId);
				$location.path("/gibi");
			}
		}, function(data) {
			console.error(data);
		});
		
		$scope.update = function(gibi) {
			GibiFactory.update($scope.gibi, function(data) {
				delete $scope.error;
				$location.path("/gibi");
			}, function(data) {
				$scope.error = "There was an error updating user!";
			});
		};
		
		$scope.remove = function(gibi) {
			GibiFactory.remove(gibi, function() {
				$location.path("/gibi");	
			});			
		};
		
		$scope.showAdvanced = function(ev) {
			var useFullScreen = ($mdMedia('sm') || $mdMedia('xs')) && $scope.customFullscreen;
			$mdDialog.show({
				templateUrl: 'gibi/edit/:gibiId',
				paret: angular.element(document.body),
				targetEvent: ev,
				clickOutsideToClose: true,
				fullscreen: useFullScreen
			})
			.then(function(answer) {
			      $scope.status = 'You said the information was "' + answer + '".';
		    }, function() {
		      $scope.status = 'You cancelled the dialog.';
		    });
			$scope.$watch(function() {
		      return $mdMedia('xs') || $mdMedia('sm');
		    }, function(wantsFullScreen) {
		      $scope.customFullscreen = (wantsFullScreen === true);
		    });
		};
	}]);

});