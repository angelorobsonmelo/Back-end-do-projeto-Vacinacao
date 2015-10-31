/**
 * 
 */
(function() {

	'use strict';

	angular.module('vacinacao')
	.factory('CadUsuarioFactory', ['$http', '$q', '$location', function($http, $q, $location) {

		function inserirUsuario(usuario) {

			var retorno = $q.defer();
			
			$http.post('rest/usuario/inserir', usuario)
			.success(function(data) {

				retorno.resolve(data);
				
			})
			.error(function(data) {

				console.log(data);
			})

			return retorno.promise; 
			
		
		}

		return {

			inserirUsuario: inserirUsuario

		}


	}])

}())