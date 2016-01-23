define([], function()
{
	return {
		defaultRoutePath: '/collections',
		routes: {
			'/menu': {
				templateUrl: 'users/list',
				controller: 'menusController',
				dependencies: [
				    'resources/app/scripts/controllers/menu/MenuController'
				]
			}
		}
	}
});