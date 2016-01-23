require.config({
	baseUrl: '/favorite-collections',
	paths: {
		'angular': 'resources/app/lib/angular/angular.min',
    	'app': 'resources/app/scripts/app',
		'angular-route': 'resources/app/lib/angular-route/angular-route.min',
		'jquery': 'resources/app/lib/jquery/jquery.min',
		'angular-animate': 'resources/app/lib/angular-animate/angular-animate.min',
		'angular-aria': 'resources/app/lib/angular-aria/angular-aria.min',
		'angular-material': 'resources/app/lib/angular-material/js/angular-material.min',
		'angular-resource': 'resources/app/lib/angular-resource/angular-resource.min',
		
	},
	shim: {
		'angular' : {
			deps: ['jquery']
		},
		'app': {
			deps: ['angular', 'angular-route', 'angular-resource', 'angular-animate', 'angular-aria', 'angular-material',]
		},
		'angular-route': {
			deps: ['angular']
		},
		'angular-resource': {
			deps: ['angular']
		},
		'angular-animate' : {
			deps: ['angular']
		},
		'angular-aria' : {
			deps: ['angular']
		},
		'angular-material' : {
			deps: ['angular']
		}
	}
});

require( ['app'], function() {
	 angular.bootstrap(document, ['app']);
});