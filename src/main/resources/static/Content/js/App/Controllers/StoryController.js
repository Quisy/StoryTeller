var StoryController = function ($scope, storyService, $log) {
    $scope.stories = storyService.get();

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
};