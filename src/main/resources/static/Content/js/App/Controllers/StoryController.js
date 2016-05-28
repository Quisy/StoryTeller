var StoryController = function ($scope, storyService, $log, authenticationService, $location) {
    $scope.stories = storyService.getAll();
    $scope.newStory = {};

    
    $scope.addStory = function(){
        $scope.newStory.userId = authenticationService.getUserId();
        if ($scope.newStory.userId != null)
        {
            storyService.add($scope.newStory);
            $location.path('/user/details');
        }
        else
        {
            $location.path('/login');
        }

    };
    

    // STORIES PAGING
    
    $scope.stories.$promise.then(function(){
        $scope.filteredStories = []
            ,$scope.currentPage = 1
            ,$scope.numPerPage = 3
            ,$scope.maxSize = 5;

        $scope.$watch('currentPage + numPerPage', function () {
            var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                , end = begin + $scope.numPerPage;

            $scope.filteredStories = $scope.stories.slice(begin, end);
        });

        $scope.pageChanged = function () {
            $log.log('Page changed to: ' + $scope.currentPage);
        }
    });



};