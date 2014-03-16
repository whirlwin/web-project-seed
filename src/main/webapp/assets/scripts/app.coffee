App = angular.module 'whirlwin', ['ngRoute']

App.config ['$locationProvider', '$routeProvider', ($locationProvider, $routeProvider) ->

  $locationProvider.html5Mode true

  console.log 'foo bar'

  ###
  $routeProvider
    .when('/',      templateUrl: '/views/index')
    .when('/login', templateUrl: '/views/login')
    .when('/blog',  templateUrl: '/views/blog/index')
  ###
]