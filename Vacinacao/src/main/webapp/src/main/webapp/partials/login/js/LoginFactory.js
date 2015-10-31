/**
 * 
 */
(function() {

	'use strict';

	angular.module('vacinacao')
	.factory('LoginFactory', ['$http', '$q', '$location', '$mdDialog', function($http, $q, $location, $mdDialog) {

		function loginConvencional(usuario) {

			var retorno = $q.defer();

			$http.get('rest/usuario/login/'+usuario.email +'/' + usuario.senha)
			.success(function(data) {

				if(data == ''){

					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.title('Aviso!')
							.content('Email ou senha incorreta')
							.ariaLabel('Alert Dialog Demo')
							.ok('OK')

					);
				}else if(data.tipoUsuario.sequencial == 2){

					retorno.resolve(data);

					$location.path('lista-de-unidades-de-saude');
				}
				else if(data.tipoUsuario.sequencial == 1){

					retorno.resolve(data);

					$location.path('campanha');
				}

			})
			.error(function(data) {

				console.log(data);
			})

			return retorno.promise; 


		}

		return {

			loginConvencional: loginConvencional

		}


	}])

}())