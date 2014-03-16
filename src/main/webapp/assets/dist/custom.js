(function() {
  var App;

  App = angular.module('whirlwin', ['ngRoute']);

  App.config([
    '$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
      return $locationProvider.html5Mode(true);

      /*
      $routeProvider
        .when('/',      templateUrl: '/views/index')
        .when('/login', templateUrl: '/views/login')
        .when('/blog',  templateUrl: '/views/blog/index')
       */
    }
  ]);

}).call(this);

(function() {
  angular.module('whirlwin').controller('IndexController', function() {});

}).call(this);
