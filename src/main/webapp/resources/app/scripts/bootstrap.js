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
		'angular-messages': 'resources/app/lib/angular-messages/angular-messages.min',
		'angular-material-icons': 'resources/app/lib/angular-material-icons-master/angular-material-icons.min',
		'md-data-table-master': 'resources/app/lib/md-data-table-master/md-data-table.min',
	},
	shim: {
		'angular' : {
			deps: ['jquery']
		},
		'app': {
			deps: ['angular', 'angular-route', 'angular-resource', 'angular-animate', 'angular-aria', 
			       	'angular-material', 'angular-messages', 'angular-material-icons', 'md-data-table-master']
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
		},
		'angular-messages' : {
			deps: ['angular']			
		},
		'angular-material-icons' : {
			deps: ['angular']
		},
		'md-data-table-master' : {
			deps: ['angular']
		}
	}
});

require( ['app'], function() {
	 angular.bootstrap(document, ['app']);
});