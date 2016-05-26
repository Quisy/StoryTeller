var App = angular.module('App', ['ngRoute','ui.bootstrap']);


//Config
App.config(RoutesConfig);

//Controllers
App.controller('indexController', IndexController);
App.controller('storyController', StoryController);
App.controller('userController', UserController);


//Services
App.factory('storyService', StoryService);

