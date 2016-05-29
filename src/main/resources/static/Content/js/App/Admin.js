var AdminModule = angular.module('AdminModule', ['ngRoute', 'ngResource', 'angularFileUpload', 'ngStorage']);

//Config
AdminModule.config(AdminRoutesConfig);

//Controllers
AdminModule.controller('indexController', AdminIndexController);
AdminModule.controller('userController', UserController);

//Services
AdminModule.factory('storyService', StoryService);
AdminModule.factory('userService', UserService);
AdminModule.factory('authenticationService', AuthenticationService);
AdminModule.factory('roleService', RoleService);



AdminModule.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);






