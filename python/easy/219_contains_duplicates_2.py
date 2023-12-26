from typing import List

class Solution:
    def containsDupllicates(self, nums) -> bool:
        alreadyMet = set()
        for i in nums:
            if i in alreadyMet:
                return True
            else:
                alreadyMet.add(i)

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        if k == 0: 
            return False

        if k >= len(nums):
            return self.containsDupllicates(nums)

        window = set()
        for i in range(0, k):
            if nums[i] in window:
                return True
            else:
                window.add(nums[i])
        
        tail = 0
        for i in range(k, len(nums)):
            if nums[i] in window:
                return True
            else:
                window.remove(nums[tail])
                tail += 1
                window.add(nums[i])
        return False

