App = angular.module 'whirlwin', ['whirlwin.blog', 'ngRoute']
Blog = angular.module 'whirlwin.blog', []

App.config ['$locationProvider', '$routeProvider', ($locationProvider, $routeProvider) ->

  $locationProvider.html5Mode true

  $routeProvider
    .when('/',      templateUrl: '/views/index')
    .when('/login', templateUrl: '/views/login')
    .when('/blog',  templateUrl: '/views/blog/index')
]