/**
 * Created by angelo on 23/06/15.
 */
(function () {

	'use strict';

	var app = angular.module('vacinacao');

	app.controller('RotaCtrl', ['$scope', '$rootScope',  '$compile', 'RotaFactory', '$location', function ($scope, $rootScope, $compile, RotaFactory, $location) {

		$rootScope.titulo = "Rota";
		$rootScope.esconderMenu = false;
		
		RotaFactory.rota();





	}]);

}());