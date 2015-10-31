/**
 * 
 */
(function() {

	'use strict';

	angular.module('vacinacao')
	.controller('LoginCtrl', ['$scope', 'LoginFactory', '$mdDialog', '$rootScope', '$location', 'UnidadeDeSaudeListaFactory', function($scope, LoginFactory, $mdDialog, $rootScope, $location, UnidadeDeSaudeListaFactory){

		$rootScope.esconderHeader = true;
		$rootScope.titulo = 'Login';
		
		$rootScope.tgState = false;

		$scope.tgState = false;

		$scope.loginConvencional = function() {

			LoginFactory.loginConvencional($scope.usuario).then(function(data) {
				
				console.log(data);
			});

		}



		$scope.alert = '';



		$scope.showAdvanced = function(ev) {
			$mdDialog.show({
				controller: DialogController,
				templateUrl: 'partials/cad-usuario/modal-cad-usuario.html',
				parent: angular.element(document.body),
				targetEvent: ev,
			})
			.then(function(answer) {
				$scope.alert = 'You said the information was "' + answer + '".';
			}, function() {
				$scope.alert = 'You cancelled the dialog.';
			});
		};



	}]);

	function DialogController($scope, $mdDialog, CadUsuarioFactory, $location) {


		$scope.genders = ['Masculino', 'Feminino', 'Outros'];


		$scope.inserirUsuario = function() {

			CadUsuarioFactory.inserirUsuario($scope.usuario).then(function(data) {

				if(data[0].resultado == 'OK'){

					$mdDialog.show(
							$mdDialog.alert()
							.parent(angular.element(document.body))
							.title('Aviso!')
							.content('Bem vindo! ' + $scope.usuario.nome +' '+ $scope.usuario.sobrenome)
							.ariaLabel('Alert Dialog Demo')
							.ok('OK')
							
					);

					$location.path('lista-de-unidades-de-saude');

					$mdDialog.hide();
				}

			})


		}

		$scope.hide = function() {
			$mdDialog.hide();
		};
		$scope.cancel = function() {
			$mdDialog.cancel();
		};
		$scope.answer = function(answer) {
			$mdDialog.hide(answer);
		};
	}


}())



