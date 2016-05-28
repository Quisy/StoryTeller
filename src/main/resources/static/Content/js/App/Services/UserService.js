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
            return registerResource.register(user, function(data) {
                console.log(data);
            }, function(error) {
                console.log(error)
            });
        },
        login: function (email, password, success, error) {
            return loginResource.login({email:email, password:password}, function(data) {
                console.log(data);
            }, function(error) {
                console.log(error)
            });
        }
    };
};
