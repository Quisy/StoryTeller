/**
 * Created by Mariusz on 2016-05-29.
 */
var RoleService = function ($resource) {
    var storiesResource = $resource('http://localhost:8080/api/role/:action/', { action: '@action' }, {
        getAll: {
            method:'GET',
            isArray:true
        }
    });


    return {
        getAll: function () {
            return storiesResource.getAll({action:'get'},function(data) {
                console.log(data);
            }, function(error) {
                console.log(error)
            });
        }
    }
};