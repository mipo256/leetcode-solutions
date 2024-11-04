class Solution:
    # the sky is blue
    #
    # blue
    # is
    # sky
    # the
    def reverseWords(self, s: str) -> str:
        words = s.strip().split(" ")

        res = ""

        for index in range(len(words) - 1, -1, -1):
            if words[index] != ' ':
                res += f" {words[index]}"

        return res[1:]