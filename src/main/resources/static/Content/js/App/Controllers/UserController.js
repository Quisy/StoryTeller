var UserController = function ($scope, storyService, $log, userService, authenticationService, $location, $route) {
    $scope.stories = storyService.get();
    $scope.newUser = {};
    $scope.loginData = {};


    $scope.register = function register()
    {
        var user = userService.register($scope.newUser);
        user.$promise.then(function(){
            authenticationService.saveUserData(user);
            console.log(user);
            $location.path("/");
        });
    };


    $scope.login = function login()
    {
        var user = userService.login($scope.loginData.email, $scope.loginData.password);
        user.$promise.then(function(){
            authenticationService.saveUserData(user);
            console.log(user);
            $location.path("/");
        });
    };



    // STORIES PAGING

    $scope.filteredStories = []
    , $scope.currentPage = 1
    , $scope.numPerPage = 5
    , $scope.maxSize = 5;


    $scope.$watch('currentPage + numPerPage', function () {
        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
        , end = begin + $scope.numPerPage;

        $scope.filteredStories = $scope.stories.slice(begin, end);
    });

    $scope.pageChanged = function () {
        $log.log('Page changed to: ' + $scope.currentPage);
    }
};