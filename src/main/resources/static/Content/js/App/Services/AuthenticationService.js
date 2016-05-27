/**
 * Created by Mariusz on 2016-05-27.
 */

var AuthenticationService =  function ($resource, $localStorage, $sessionStorage) {

    return {
        saveUserData: function(user)
        {
            $sessionStorage.userInfo = angular.toJson(user);
            console.log($sessionStorage.userInfo);
        }
    };
}