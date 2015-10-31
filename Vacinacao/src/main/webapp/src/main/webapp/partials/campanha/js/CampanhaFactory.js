/**
 * 
 */
(function() {

	'use strict';

	angular.module('vacinacao')
	.factory('CampanhaFactory', ['$http', '$q', '$location', '$mdDialog', function($http, $q, $location, $mdDialog) {

		function consultarTodos(){

			var retorno = $q.defer();

			$http.get('rest/campanha/consultarTodos')
			.success(function (resposta) {

				retorno.resolve(resposta);
			})
			.error(function(resposta) {

				console.log(resposta);
			})
			return retorno.promise;

		}

		function salvarCampanha(campanha) {

			var retorno = $q.defer();

			$http.post('rest/campanha/salvar', campanha)
			.success(function (resposta) {

				retorno.resolve(resposta);
			})
			.error(function(resposta) {

				console.log(resposta);
			})
			return retorno.promise;


		}

		function remover(campanha, ev) {

			var retorno = $q.defer();


			var confirm = $mdDialog.confirm()
			.title('Deseja realmente excluir?')
			.content(campanha.titulo)
			.ariaLabel('Lucky day')
			.targetEvent(ev)
			.ok('Sim')
			.cancel('Não');
			$mdDialog.show(confirm).then(function() {

				$http.delete('rest/campanha/remover/'+ campanha.sequencial)
				.success(function (resposta) {

					retorno.resolve(resposta);
				})
				.error(function(resposta) {

					console.log(resposta);
				})

			});




			return retorno.promise;

		}

		return {

			consultarTodos: consultarTodos,
			salvarCampanha: salvarCampanha,
			remover: remover

		}


	}])

}())