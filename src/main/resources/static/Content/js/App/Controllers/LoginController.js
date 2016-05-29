/**
 * Created by Mariusz on 2016-05-28.
 */
var LoginController = function ($scope, $log, userService, authenticationService, $location) {

    $scope.newUser = {};
    $scope.loginData = {};


    $scope.register = function register()
    {
        var user = userService.register($scope.newUser);
        user.$promise.then(function successCallback(response) {
            console.log(response);
            authenticationService.saveUserData(user);
            $location.path("/");
        }, function errorCallback(response) {
            console.log(response);
            alert('Wrong data');

        });
    };


    $scope.login = function login()
    {
        var user = userService.login($scope.loginData.email, $scope.loginData.password);
        user.$promise.then(function successCallback(response) {
            console.log(response);
            authenticationService.saveUserData(user);
            $location.path("/");
        }, function errorCallback(response) {
            console.log(response);
            alert('Wrong data');

        });
    };





};
