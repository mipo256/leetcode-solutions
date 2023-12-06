class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) return 0;
            return arr1[0] > arr2[0] ? 1 : -1;
        });

        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.getLast();

            int[] currentInterval = intervals[i];

            if (withinInterval(last, currentInterval[0])) {
                if (last[1] < currentInterval[1]) {
                    last[1] = currentInterval[1];
                }
            } else {
                merged.add(currentInterval);
            }
        }

        int[][] response = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            response[i] = merged.get(i);
        }

        return response;
    }

    private boolean withinInterval(int[] interval, int number) {
        return interval[0] <= number && interval[1] >= number;
    }
}
