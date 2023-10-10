class Solution {
    // 1..8 [4,3,2,7,8,2,3,1]
    // [x x x x 5 6 x x]
    // 1 2 2 3 3 4 7 8
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for (int x : nums) {
            int index = Math.abs(x) - 1;
            nums[index] = Math.abs(nums[index]) * (-1);
        }

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        } 
        return list;
    }
}
