define(['app'], function (app) {
	app.factory('SaintSeiyaFactory', ['$resource', function($resource) {
		return $resource("saint-seiya", {}, {
			show : {
				method : 'GET',
				url : 'saint-seiya'
			}			
		});
	}]);
	
	app.factory('SaintSeiyaPublishingCompanyFactory', ['$resource', function($resource) {
		return $resource("saint-seiya", {}, {
			show : {
				method : 'GET',
				url : 'saint-seiya/:id'
			},
			showEdition : {
				method : 'GET',
				url : 'saint-seiya/:id/:id_',
				params : {
					id : '@id',
					id_ : '@editions.id'
				}	
			
			},
			update : {
				method : 'PUT',
				params : {
					id : '@id'
				}
			}
		});
	}]);
		
	app.controller("saintSeiyaController",  ['$scope', '$rootScope', '$mdMedia', '$mdDialog', '$mdMedia', '$log', 'SaintSeiyaFactory',	
	                                         	function($rootScope, $scope, $mdMedia, $mdDialog, $mdMedia, $log, SaintSeiyaFactory) {
		$scope.title = 'Saint Seiya';
		$scope.gibi = SaintSeiyaFactory.show();
	}]);
	
	app.controller("saintSeiyaPublishingCompanyController",  ['$scope', '$rootScope', '$routeParams', '$mdMedia', '$mdDialog', '$mdMedia', '$log', 'SaintSeiyaPublishingCompanyFactory',	
	                                         	function($rootScope, $scope, $routeParams, $mdMedia, $mdDialog, $mdMedia, $log, SaintSeiyaPublishingCompanyFactory) {
		
		SaintSeiyaPublishingCompanyFactory.show({
			id : $routeParams.id
		}, function(data) {
			if(data.id) {
				$scope.publishingCompany = data;
				$scope.title = 'Saint Seiya ' + data.name + '!';
			} else {
				console.error("No Saint Seiya gibi with id: " + $routeParams.id);
				$location.path("/saint-seiya");
			}
		}, function(data) {
			console.error(data);
		});
		
		$scope.update = function(publishingCompany) {
			SaintSeiyaPublishingCompanyFactory.update($scope.publishingCompany, function(data) {
				delete $scope.error;
				$location.path("/saint-seiya");
			}, function(data) {
				$scope.error = "There was an error updating gibi!";
			});
		};
		
		$scope.showTabPublishingCompany = showTabPublishingCompany;
		
		function showTabPublishingCompany($event) {
		    $mdDialog.show({
		      templateUrl: 'saint_seiya/gibi/conrad',
		      parent: angular.element(document.body),
		      targetEvent: $event,
		      clickOutsideToClose:true
		    })
	        .then(function(answer) {
	          $scope.status = 'You said the information was "' + answer + '".';
	        }, function() {
	          $scope.status = 'You cancelled the dialog.';
	        });
		  }	
		
		$scope.hide = function() {
			$mdDialog.hide();
		};
		$scope.cancel = function() {
			$mdDialog.cancel();
		};
		$scope.answer = function(answer) {
			$mdDialog.hide(answer);
		};			
	}]);
	
	app.controller("saintSeiyaEditionController",  ['$scope', '$rootScope', '$routeParams', '$location', 'SaintSeiyaPublishingCompanyFactory',	
	          	                                         	function($rootScope, $scope, $routeParams, $location, SaintSeiyaPublishingCompanyFactory) {
		
		SaintSeiyaPublishingCompanyFactory.showEdition({id : $routeParams.id, id_:$routeParams.id_}, function(data) {
			if(data.id) {
				$scope.edition = data;
				$scope.title = 'Saint Seiya !';
			} else {
				console.error("No Saint Seiya gibi with id: " + $routeParams.id);
				$location.path("/saint-seiya");
			}
		}, function(data) {
			console.error(data);
		});
		
	}]);
});