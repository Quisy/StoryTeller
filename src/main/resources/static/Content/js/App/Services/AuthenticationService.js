/**
 * Created by Mariusz on 2016-05-27.
 */

var AuthenticationService =  function ($rootScope,$resource, $localStorage, $sessionStorage) {

    var session = $sessionStorage;

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
            $rootScope.userLogInfo = {
                isLogged: true,
                isAdmin: userInfo.Role == 'admin'
            };
        },
        isAdmin: function()
        {
            if (session.userInfo == null)
                return false;

            var user = angular.fromJson(session.userInfo);

            return user.Role == 'admin';

        },
        isLogged: function()
        {
            return session.userInfo != null;
        },
        logout: function()
        {
            delete session.userInfo;
            $rootScope.userLogInfo = {
                isLogged: false,
                isAdmin: false
            };
        },
        getUserId: function()
        {
            if (session.userInfo == null)
                return null;

            return angular.fromJson(session.userInfo).Id;
        }


    };
};