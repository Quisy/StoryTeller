/**
 * Created by Mariusz on 2016-05-28.
 */

var AdminRoutesConfig = function ($routeProvider, $locationProvider) {
    $routeProvider.when('/',
        {
            templateUrl: 'partial/users/index.html',
            controller: 'userController'
        })
        .when('/users',
            {
                templateUrl: 'partial/users/index.html',
                controller: 'userController'
            })
        .otherwise({
            redirectTo: '/'
        });

}