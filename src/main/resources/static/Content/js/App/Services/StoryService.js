var StoryService = function ($resource) {
    var storiesResource = $resource('http://localhost:8080/api/story/:action/:id', { action: '@action', id: '@id' }, {
        getAll: {
            method:'GET',
            isArray:true
        },
        add: {
            method:'POST'
        }
    });


    return {
        getAll: function () {
            return storiesResource.getAll({action:'get'});
        },
        getForUser: function(userId){
            return storiesResource.get({action:'getUsers', id:userId});
        },
        add: function(story){
            storiesResource.add({action:'add'}, story);
        }

    }
};