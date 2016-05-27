var App = angular.module('App', ['ngRoute','ui.bootstrap', 'ngResource', 'ngStorage']);


//Config
App.config(RoutesConfig);

//Controllers
App.controller('indexController', IndexController);
App.controller('storyController', StoryController);
App.controller('userController', UserController);


//Services
App.factory('storyService', StoryService);
App.factory('userService', UserService);
App.factory('authenticationService', AuthenticationService);

