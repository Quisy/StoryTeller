/**
 * Created by Mariusz on 2016-05-26.
 */

var UserService =  function ($resource, authenticationService) {

    var registerResource = $resource('http://localhost:8080/api/users/register', {
        register : {
            method:'POST'
        }
    });

    var loginResource = $resource('http://localhost:8080/api/users/login/:email/:password', { email: '@email', password: '@password' }, {
        login : {
            method:'GET'
        }
    });


    return {
        register: function (user, success, error) {
            var userInfo = {};
            registerResource.register(user, function(data) {
                console.log(data);
                userInfo.Name = data.name;
                userInfo.Surname = data.surname;
                userInfo.Email = data.email;
                userInfo.NickName = data.nickName;
                userInfo.Role  = data.role.name;
                authenticationService.saveUserData(userInfo);
            }, function(error) {
                console.log(error)
            });
        },
        login: function (email, password, success, error) {
            var userInfo = {};
            loginResource.login({email:email, password:password}, function(data) {
                console.log(data);
                userInfo.Name = data.name;
                userInfo.Surname = data.surname;
                userInfo.Email = data.email;
                userInfo.NickName = data.nickName;
                userInfo.Role  = data.role.name;
                authenticationService.saveUserData(userInfo);
            }, function(error) {
                console.log(error)
            });
        }
    };
}
