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
            controller: 'loginController'
        })
         .when('/register',
        {
            templateUrl: 'partial/user/register.html',
            controller: 'loginController'
        })
        .when('/story/add',
            {
                templateUrl: 'partial/story/add.html',
                controller: 'storyController'
            })
        .otherwise({
            redirectTo: '/',
        });

    //if (window.history && window.history.pushState) {
    //    $locationProvider.html5Mode(true);
    //}

}