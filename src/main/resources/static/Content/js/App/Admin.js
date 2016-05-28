var AdminModule = angular.module('AdminModule', ['ngRoute', 'ngResource', 'angularFileUpload', 'ngStorage']);

//Config
AdminModule.config(AdminRoutesConfig);

//Controllers
AdminModule.controller('indexController', IndexController);
AdminModule.controller('userController', UserController);

//Services
AdminModule.factory('storyService', StoryService);
AdminModule.factory('userService', UserService);
AdminModule.factory('authenticationService', AuthenticationService);









