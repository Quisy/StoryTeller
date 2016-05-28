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
App.factory('authenticationService', AuthenticationService);

