(function() {
  var App;

  App = angular.module('whirlwin', ['ngRoute']);

  App.config([
    '$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
      return $routeProvider.when('/', {
        templateUrl: 'assets/dist/html/foo.html'
      }).when('/foo', {
        templateUrl: 'assets/dist/html/foo.html'
      }).when('/bar', {
        templateUrl: 'assets/dist/html/other/bar.html'
      }).when('/baz', {
        templateUrl: 'assets/dist/html/other/baz.html'
      });
    }
  ]);

}).call(this);

(function() {
  angular.module('whirlwin').controller('IndexController', function() {});

}).call(this);
