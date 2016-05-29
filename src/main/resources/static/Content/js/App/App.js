var App = angular.module('App', ['ngRoute','ui.bootstrap', 'ngResource', 'ngStorage']);


//Values
App.value('userLog', { isLogged: false, isAdmin: false});

//Config
App.config(RoutesConfig);

//Controllers
App.controller('indexController', IndexController);
App.controller('loginController', LoginController);
App.controller('storyController', StoryController);
App.controller('userController', UserController);


//Services
App.factory('storyService', StoryService);
App.factory('userService', UserService);
App.factory('roleService', RoleService);
App.factory('authenticationService', AuthenticationService);


App.directive("fileread", [function () {
    return {
        scope: {
            fileread: "="
        },
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.fileread = loadEvent.target.result;
                    });
                }
                reader.readAsDataURL(changeEvent.target.files[0]);
            });
        }
    }
}]);

App.directive('fileModel', ['$parse', function ($parse) {
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



