define([], function()
{
	return {
		defaultRoutePath: '/collections',
		routes: {
			'/menu': {
				templateUrl: 'menus/list',
				controller: 'menusController',
				dependencies: [
				    'resources/app/scripts/controllers/menu/MenuController'
				]
			},
			'/gibi' : {
				templateUrl : 'gibis/list',
				controller: 'gibisController',
				dependencies: [
				   'resources/app/scripts/controllers/gibi/GibiController'
				]
			},
			'/gibi/:gibiId' : {
				templateUrl : 'gibi/show/:gibiId',
				controller: 'gibiController',
				dependencies: [
				   'resources/app/scripts/controllers/gibi/GibiController'
				]
			},
			'/gibi/edit/:gibiId' : {
				templateUrl : 'gibi/edit/:gibiId',
				controller: 'gibiController',
				dependencies: [
				   'resources/app/scripts/controllers/gibi/GibiController'
				]
			}			
		}
	}
});