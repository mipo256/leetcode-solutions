from typing import List

class Solution:
    def findContentChildren(self, greed: List[int], cookies: List[int]) -> int:
        greed.sort()
        cookies.sort()

        greed_index = 0

        for cookies_index in range(len(cookies)):
            if cookies[cookies_index] >= greed[greed_index]:
                greed_index += 1
        
        return greed_index
    
