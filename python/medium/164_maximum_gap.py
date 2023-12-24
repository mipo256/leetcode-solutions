from typing import List
from math import floor

class Solution:
    def bucket_sort(self, nums: List[int]):
        buckets = [[] for i in range(0, len(nums))]
        buckets_amount = len(nums)
        max_val = max(nums)
        
        for n in nums: 
            bucket_number = floor((buckets_amount * n) / (max_val + 1))
            buckets[bucket_number].append(n)
        
        nums.clear()

        for b in buckets:
            b.sort()
            nums.extend(b)


    def maximumGap(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        elif len(nums) == 2:
            return nums[1] - nums[0]
        else:
            self.bucket_sort(nums)
            previous = nums[0]
            result = -1
            for i in range(1, len(nums)):
                current = nums[i]
                result = max(result, current - previous)
                previous = current
            return result
