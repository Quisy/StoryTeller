var IndexController = function ($scope, authenticationService, $window) {


    $scope.logout = function()
    {
        authenticationService.logout();
        $window.location.reload();
    }
};
