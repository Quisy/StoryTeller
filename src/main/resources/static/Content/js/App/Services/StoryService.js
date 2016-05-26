var StoryService = function () {
    var x = function generateStories() {
        return [
            {
                title: 'Story 1',
                content: 'Story 1 content'
            },
            {
                title: 'Story 2',
                content: 'Story 2 content'
            },
            {
                title: 'Story 3',
                content: 'Story 3 content'
            },
            {
                title: 'Story 4',
                content: 'Story 4 content'
            },
            {
                title: 'Story 5',
                content: 'Story 5 content'
            },
            {
                title: 'Story 6',
                content: 'Story 6 content'
            },
            {
                title: 'Story 7',
                content: 'Story 7 content'
            }
        ];
    }

    return {
        get: function () {
            return x();
        }
    }
}