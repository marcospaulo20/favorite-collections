define([], function()
{
	return {
		defaultRoutePath: '/collections',
		routes: {			
			// Animation
			// Saint Seiya - Anime & Gibi
			'/saint-seiya' : {
				templateUrl : 'saint_seiya/index',
				controller: 'saintSeiyaController',
				dependencies: [ 'resources/app/scripts/controllers/animation/saint_seiya/SaintSeiyaController' ]
			},
			'/saint-seiya/:id' : {
				templateUrl : 'saint_seiya/gibi/publishingCompany',
				controller: 'saintSeiyaPublishingCompanyController',
				dependencies: [ 'resources/app/scripts/controllers/animation/saint_seiya/SaintSeiyaController' ]
			},
			'/saint-seiya/:id/:id_' : {
				templateUrl : 'saint_seiya/gibi/edition',
				controller: 'saintSeiyaEditionController',
				dependencies: [ 'resources/app/scripts/controllers/animation/saint_seiya/SaintSeiyaController' ]
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