var IndexController = function ($scope, $rootScope, authenticationService, $window) {

    $rootScope.userLogInfo = {
        isLogged: authenticationService.isLogged(),
        isAdmin: authenticationService.isAdmin()
    };

    $scope.logout = function()
    {
        authenticationService.logout();
        $window.location.reload();
    }
};
