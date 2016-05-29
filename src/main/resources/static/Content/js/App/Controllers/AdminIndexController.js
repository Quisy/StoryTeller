/**
 * Created by Mariusz on 2016-05-28.
 */

var AdminIndexController = function ($scope, $rootScope, authenticationService, $window) {



    var checkPrivileges = function()
    {
        if (!authenticationService.isAdmin())
            $window.location.href = '/';
    };

    var init = function()
    {
        checkPrivileges();
        $rootScope.userLogInfo = {
            isLogged: authenticationService.isLogged(),
            isAdmin: authenticationService.isAdmin()
        };
    };


    init();

};

