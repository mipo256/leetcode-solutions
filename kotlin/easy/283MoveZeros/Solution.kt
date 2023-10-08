class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var i = -1

        for (k in 0 until nums.size) {
            if (nums[k] != 0) {
                if (nums[i + 1] == 0) {
                    nums[i + 1] = nums[k]
                    i += 1
                    nums[k] = 0
                } else {
                    i += 1
                }
            }
        }
    }
}
