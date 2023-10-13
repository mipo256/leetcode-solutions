class Solution {

    fun majorityElement(nums: IntArray): Int {
        var result = nums[0]
        var majorityCounter = 1;

        for (i in 1 until nums.size) {
            val it = nums[i]
            if (result != it) {
                if (majorityCounter == 0) {
                    result = it
                    majorityCounter = 1
                } else {
                    majorityCounter -= 1
                }
            } else {
                majorityCounter += 1
            }
        }
        
        return result
    }

}
