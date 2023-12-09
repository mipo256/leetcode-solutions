from typing import List

class Solution:
                
    def overlaps(self, currentInterval, newInterval):
        return (
            (newInterval[0] <= currentInterval[1] and newInterval[0] >= currentInterval[0]) 
            or 
            (newInterval[1] >= currentInterval[0] and newInterval[1] <= currentInterval[1])
        )
    
    def is_within(self, enclosing, candidate):
        return enclosing[0] <= candidate[0] and enclosing[1] >= candidate[1]
    
    def merge(self, first, second):
        return [min(first[0], second[0]), max(first[1], second[1])]

    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:

        replaced = False 
        i = 0

        while i < len(intervals):
            currentInterval = intervals[i]
            if not replaced:
                if self.overlaps(currentInterval, newInterval):
                    if self.is_within(currentInterval, newInterval):
                        return intervals
                    else: 
                        intervals[i] = self.merge(currentInterval, newInterval)
                    replaced = True
                i += 1
            else:
                previous = intervals[i - 1]
                if previous[1] >= currentInterval[1]:
                    del intervals[i]
                elif previous[1] >= currentInterval[0]:
                    intervals[i - 1] = [previous[0], currentInterval[1]]
                    del intervals[i]
                    return intervals
                else:
                    return intervals
        if not replaced:
            intervals.append(newInterval)
        return intervals

print(Solution().insert([[1,2],[3,4],[7,11],[12,14]], [1,8]))

print(Solution().insert([[1,5]], [0,3]))