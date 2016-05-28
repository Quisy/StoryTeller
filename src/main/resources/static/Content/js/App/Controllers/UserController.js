var UserController = function ($scope, storyService, $log, userService, authenticationService, $location) {

    $scope.user = {};

    var init = function () {
        if (!authenticationService.isLogged())
            $location.path("/");

        $scope.user = userService.getInfo(authenticationService.getUserId());
    };


    init();

    // STORIES PAGING

    $scope.user.$promise.then(function(){
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