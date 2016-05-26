var RoutesConfig = function ($routeProvider, $locationProvider) {
    $routeProvider.when('/',
        {
            templateUrl: 'partial/home/storiesList.html',
            controller: 'storyController'
        })
        .when('/user/details',
        {
            templateUrl: 'partial/user/details.html',
            controller: 'userController'
        })
        .when('/login',
        {
            templateUrl: 'partial/user/register.html',
            controller: 'indexController'
        })
         .when('/register',
        {
            templateUrl: 'partial/user/register.html',
            controller: 'indexController'
        })
        .otherwise({
            redirectTo: '/',
        });

    //if (window.history && window.history.pushState) {
    //    $locationProvider.html5Mode(true);
    //}

}