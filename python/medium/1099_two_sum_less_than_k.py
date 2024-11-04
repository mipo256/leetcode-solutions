from typing import (
    List,
)

class Solution:
    """
    @param nums: An array of integer
    @param target: An integer
    @return: The sum of two numbers smaller than target
    """
    def two_sum_less_than_target(self, nums: List[int], target: int) -> int:
        nums.sort()
        left, right = 0, len(nums) - 1

        res = -10000
        found = False

        while left < right:
            sum = nums[left] + nums[right]
            if sum < target:
                res = max(res, sum)
                found = True
                left += 1
            else:
                right -= 1

        return -1 if not found else res