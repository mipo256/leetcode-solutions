class Solution:
    def minSteps(self, s: str, t: str) -> int:
        source = {}

        for symbol in s:
            val = source.get(symbol)
            if val is None:
                source[symbol] = 1
            else:
                source[symbol] = val + 1

        result = 0

        for symbol in t:
            val = source.get(symbol)
            if val == 0 or val is None:
                result += 1
            else:
                source[symbol] -= 1

        return result
