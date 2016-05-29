/**
 * Created by Mariusz on 2016-05-26.
 */

var UserService =  function ($resource, authenticationService) {

    var userResource = $resource('http://localhost:8080/api/users/:action/:id', { action: '@action', id: '@id' }, {
        register : {
            method:'POST'
        },
        getInfo : {
            method:'GET'
        },
        getAll : {
            method:'GET',
            isArray:true
        },
        update : {
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
            return userResource.register({action:'register'}, user);
        },
        login: function (email, password, success, error) {
            return loginResource.login({email: email, password: password});
        },
        getInfo: function (userId, success, error) {
            return userResource.getInfo({action:'info', id:userId});
        },
        getAll: function (success, error) {
            return userResource.getAll({action:'get'});
        },
        update: function (user, success, error) {
            console.log(user);
            return userResource.update({action:'update', id:null}, user);
        }
    };
};
