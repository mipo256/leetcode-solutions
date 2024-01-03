from typing import List

class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        met = {}
        result = []
        for n in nums:
            ocurrencies = met.get(n)
            if ocurrencies is None:
                if len(result) == 0:
                    result.append([n])
                else:
                    result[0].append(n)
            else:
                if len(result) - 1 < ocurrencies:
                    result.append([n])
                else:
                    result[ocurrencies].append(n)
            met[n] = met[n] + 1 if met.get(n) is not None else 1
        return result