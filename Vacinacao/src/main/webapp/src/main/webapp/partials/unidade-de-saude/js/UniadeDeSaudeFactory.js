/**
 * 
 */
(function() {

	'use strict';

	angular.module('vacinacao')
	.factory('UnidadeDeSaudeFactory', ['$http', '$q', '$location', '$mdDialog', function($http, $q, $location, $mdDialog) {


		function consultarTodos(){

			var retorno = $q.defer();

			$http.get('rest/unidadeDeSaude/consultarTodas')
			.success(function (resposta) {

				retorno.resolve(resposta);
			})
			.error(function(resposta) {

				console.log(resposta);
			})
			return retorno.promise;

		}

		function salvar(unidadeDeSaude) {

			var retorno = $q.defer();

			$http.post('rest/unidadeDeSaude/salvar', unidadeDeSaude)
			.success(function (resposta) {

				retorno.resolve(resposta);
			})
			.error(function(resposta) {

				console.log(resposta);
			})
			return retorno.promise;


		}

		function remover(unidadeDeSaude, ev) {

			var retorno = $q.defer();


			var confirm = $mdDialog.confirm()
			.title('Deseja realmente excluir?')
			.content(unidadeDeSaude.nome)
			.ariaLabel('Lucky day')
			.targetEvent(ev)
			.ok('Sim')
			.cancel('Não');
			$mdDialog.show(confirm).then(function() {

				$http.delete('rest/unidadeDeSaude/remover/'+ unidadeDeSaude.sequencial)
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
			salvar: salvar,
			remover: remover

		}


	}])

}())