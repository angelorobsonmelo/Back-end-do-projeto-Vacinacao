/**
 * Created by angelo on 23/06/15.
 */

(function () {

	'use strict';

	var app = angular.module('vacinacao');

	app.factory('UnidadeDeSaudeListaFactory', ['$http', '$q', '$rootScope', function ($http, $q, $rootScope) {

		// Try HTML5 geolocation.
		var pos;
		var listaDeUnidadeDeSaude = [];

		function pegarMinhaLocalizacao() {

			var retorno = $q.defer();

			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {

					pos = {
							lat: position.coords.latitude,
							lng: position.coords.longitude
					};

					listarUnidadesDeSaude().then(function(resposta) {

						retorno.resolve(resposta);

					});

				});
			} 

			return retorno.promise;

		}

		function listarUnidadesDeSaude(){

			var retorno = $q.defer();

			$http.get('rest/unidadeDeSaude/consultarTodas')
			.success(function (resposta) {

				angular.forEach(resposta, function(valor) {

					googleApiDistanceMatrix(valor).then(function(resposta) {

						listaDeUnidadeDeSaude.push(resposta);
						retorno.resolve(listaDeUnidadeDeSaude);

					});

				});

			})
			.error(function (data) {
				console.log(data);
			});

			return retorno.promise;

		}

		function googleApiDistanceMatrix(valor){

			var retorno = $q.defer();

			var minhaOrigem = pos;
			var destino = new google.maps.LatLng(valor.latitude, valor.longitude);

			var service = new google.maps.DistanceMatrixService();
			service.getDistanceMatrix(
					{
						origins: [minhaOrigem],
						destinations: [destino],
						travelMode: google.maps.TravelMode.DRIVING,
						avoidHighways: false,
						avoidTolls: false
					}, callback);

			function callback(response, status) {

				if (status == google.maps.DistanceMatrixStatus.OK) {
					var origins = response.originAddresses;
					var destinations = response.destinationAddresses;

					for (var i = 0; i < origins.length; i++) {
						var results = response.rows[i].elements;
						for (var j = 0; j < results.length; j++) {
							var element = results[j];

							var distance = element.distance.text;
							var duration = element.duration.text;
							var distanceBrute = element.duration.value;
							var from = origins[i];
							var to = destinations[j];

							valor.distancia = distance;
							valor.distanciaBruta = distanceBrute;
							valor.de = from;
							valor.para = to;
							valor.duracao = duration;

							retorno.resolve(valor);

						}

					}

				}else{
					console.log("Erro na matrix.")
				}
			}

			return retorno.promise;

		}

		return {

			pegarMinhaLocalizacao: pegarMinhaLocalizacao

		}

	}]);

}())