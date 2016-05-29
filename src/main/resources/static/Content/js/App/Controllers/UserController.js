﻿var UserController = function ($scope, storyService, $log, userService, authenticationService, $window, roleService) {

    $scope.users = [];
    $scope.user = {};
    $scope.roles = roleService.getAll();

    var init = function () {
        if (!authenticationService.isLogged())
            $window.location.href = '/';

        $scope.user = userService.getInfo(authenticationService.getUserId());

    };


    init();

    
    $scope.getUsers = function()
    {
        $scope.users = userService.getAll();
    };

    $scope.getUser = function(userId)
    {
        
        $scope.user = userService.getInfo(userId);
    };

    $scope.updateUser = function()
    {
        userService.update($scope.user);
        $window.location.reload();
    };

    // STORIES PAGING

    $scope.user.$promise.then(function(){
        console.log($scope.user.stories);
        $scope.filteredStories = []
            , $scope.currentPage = 1
            , $scope.numPerPage = 5
            , $scope.maxSize = 5;


        $scope.$watch('currentPage + numPerPage', function () {
            var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                , end = begin + $scope.numPerPage;

            $scope.filteredStories = $scope.user.stories.slice(begin, end);
        });

        $scope.pageChanged = function () {
            $log.log('Page changed to: ' + $scope.currentPage);
        }
    })


};