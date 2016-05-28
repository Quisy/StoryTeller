/**
 * Created by Mariusz on 2016-05-27.
 */

var AuthenticationService =  function ($rootScope,$resource, $localStorage, $sessionStorage) {

    return {
        saveUserData: function(user)
        {
            var userInfo = {};
            userInfo.Id = user.id;
            userInfo.Name = user.name;
            userInfo.Surname = user.surname;
            userInfo.Email = user.email;
            userInfo.NickName = user.nickName;
            userInfo.Role  = user.role.name;
            $sessionStorage.userInfo = angular.toJson(userInfo);
            console.log($sessionStorage.userInfo);
            $rootScope.userLogInfo = {
                isLogged: true,
                isAdmin: userInfo.Role == 'admin'
            };
        },
        isAdmin: function()
        {
            if ($sessionStorage.userInfo == null)
                return false;

            var user = angular.fromJson($sessionStorage.userInfo);

            return user.Role == 'admin';

        },
        isLogged: function()
        {
            return $sessionStorage.userInfo != null;
        },
        logout: function()
        {
            delete $sessionStorage.userInfo;
            $rootScope.userLogInfo = {
                isLogged: false,
                isAdmin: false
            };
        }

    };
};