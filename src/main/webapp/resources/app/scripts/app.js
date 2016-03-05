define(['resources/app/scripts/routes',
        'resources/app/scripts/services/dependencyResolverFor'],
        
    function(config, dependencyResolverFor) {
		var app = angular.module('app', ['ngRoute', 'ngResource', 'ngAria', 'ngMaterial', 'ngMessages', 'ngMdIcons', 'md.data.table', 'ngMenuSidenav']);
		
		app.config(
		[
		 	'$routeProvider',
		 	'$locationProvider',
		 	'$controllerProvider',
		 	'$compileProvider',
		 	'$filterProvider',
		 	'$provide',
		 	
		 	function($routeProvider, $locationProvider, $controllerProvider, $compileProvider, $filterProvider, $provide) {
		 		app.controller = $controllerProvider.register;
		 		app.directive = $compileProvider.directive;
		 		app.filter = $filterProvider.register;
		 		app.factory = $provide.factory;
		 		app.service = $provide.service;
		 		
		 		$locationProvider.html5Mode(false);
		 		
		 		if(config.routes !== undefined) {
	                angular.forEach(config.routes, function(route, path) {
	                    $routeProvider.when(path, {templateUrl:route.templateUrl, resolve:dependencyResolverFor(route.dependencies)});
	                });
	            }
		 		
		 		if(config.defaultRoutePaths !== undefined) {
		 			$routeProvider.otherwise({redirectTo:config.defaultRoutePaths});
		 		}
		 	}
		]);
		
		app.directive("menuToggle", ['$timeout' ,function($timeout) {
		    return {
		        scope: {
		        	section: '='
		        },
		        link: function(scope, element) {
		        	var controller = element.parent().controller();
		        	
		        	scope.isOpen = function() {
		        		return controller.isOpen(scope.section);
		        	};
		        	scope.toggle = function () {
		        		controller.toggleOpen(scope.section);
		        	};
		             
		        	var parentNode = element[0].parentNode.parentNode.parentNode;
		        	if (parentNode.classList.contains('parent-list-item')) {
		                var heading = parentNode.querySelector('h2');
		                element[0].firstChild.setAttribute('aria-describedby', heading.id);
		        	}
		        }
		    };
		}]);			
		
		app.run(['', function($mdSidenav, $rootScope) {			
			 
			$rootScope.title = 'HOME';
	    	$rootScope.index = 0;
	    	$rootScope.toggleSidenav = function(menuId) {
	    		$mdSidenav(menuId).toggle();
	    	};	    		    
	    }]);
		
		return app;
});