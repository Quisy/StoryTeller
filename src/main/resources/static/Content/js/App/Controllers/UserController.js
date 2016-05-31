var UserController = function ($scope, storyService, $log, userService, authenticationService, $window, roleService) {

    $scope.users = [];
    $scope.user = {};
    $scope.roles = roleService.getAll();

    $scope.avatar = {};
    $scope.avatar.src = "";

    var init = function () {
        if (!authenticationService.isLogged())
            $window.location.href = '/';

        $scope.user = userService.getInfo(authenticationService.getUserId());

    };


    init();


    $scope.uploadFile = function() {
        var fd = new FormData();
        //Take the first selected file
        console.log($scope.avatar);
        fd.append("file", $scope.avatar);
        console.log(fd);
        userService.uploadAvatar(fd,authenticationService.getUserId());

        $window.location.reload();

    };


    $scope.delete = function()
    {
        userService.delete($scope.user.id);
        $window.location.reload();
    };

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