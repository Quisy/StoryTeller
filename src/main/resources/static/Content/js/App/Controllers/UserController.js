var UserController = function ($scope, storyService, $log, userService) {
    $scope.stories = storyService.get();
    $scope.newUser = {};
    $scope.loginData = {};


    //REGISTER METHOD
    $scope.register = function register()
    {
        userService.register($scope.newUser);
    };

    $scope.login = function login()
    {
        userService.login($scope.loginData.email, $scope.loginData.password);
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