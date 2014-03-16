App = angular.module 'whirlwin', ['ngRoute']

App.config ['$locationProvider', '$routeProvider', ($locationProvider, $routeProvider) ->

  # May not work in IE
  # $locationProvider.html5Mode false

  $routeProvider
    .when('/',    templateUrl: '/assets/dist/html/foo.html')
    .when('/foo', templateUrl: '/assets/dist/html/foo.html')
    .when('/bar', templateUrl: '/assets/dist/html/other/bar.html')
    .when('/baz', templateUrl: '/assets/dist/html/other/baz.html')
]