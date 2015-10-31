(function () {
    'use strict';

   var app = angular.module('vacinacao', ['ngRoute', 'ngMaterial', 'ngAnimate', 'ngMessages', 'ngAria', 'ngHamburger', 'ngMap']);
   
        app.config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                 .when('/', {
                    controller: 'UsuarioCtrl',
                    templateUrl: 'partials/usuario/usuario.html'
                })
                .when('/lista-de-unidades-de-saude', {
                    controller: 'UnidadeDeSaudeListaCtrl',
                    templateUrl: 'partials/unidade-de-saude-lista/unidade-de-saude-lista.html'
                })
                 .when('/lista-de-unidades-de-saude-mapa', {
                    controller: 'ListaUnidadeDeSaudeMapaCtrl',
                    templateUrl: 'partials/unidade-de-saude-lista-mapa/unidade-de-saude-lista-mapa.html'
                })
                 .when('/detalhes-unidade-de-saude', {
                    controller: 'DetalhesCtrl',
                    templateUrl: 'partials/detalhes-unidade-de-saude/detalhes-unidade-de-saude.html'
                })
                .when('/ver-unidade-de-saude-no-mapa', {
                    controller: 'VerUnidadeDeSaudeNoMapaCtrl',
                    templateUrl: 'partials/ver-unidade-de-saude-no-mapa/ver-unidade-de-saude-no-mapa.html'
                })
                .when('/rota', {
                    controller: 'RotaCtrl',
                    templateUrl: 'partials/rota/rota.html'
                })
                .when('/simple-map', {
                    controller: 'SimpleMapCtrl',
                    templateUrl: 'partials/simple-map/simple-map.html'
                })
                 .when('/campanha', {
                    controller: 'CampanhaCtrl',
                    templateUrl: 'partials/campanha/campanha.html'
                })
                 .when('/', {
                    controller: 'LoginCtrl',
                    templateUrl: 'partials/login/login.html'
                })
                .otherwise('/');
        }]);
        
        app.config(function ($mdThemingProvider) {
            $mdThemingProvider.theme('custom', 'default')
                .primaryPalette('light-green')
                .accentPalette('deep-purple');
          });

}());