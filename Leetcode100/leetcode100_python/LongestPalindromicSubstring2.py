class Solution:
    def centerExpend(slef, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return right - left - 1
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        max_len = 0
        res = ""
        for i in range(len(s)):
            len1 = self.centerExpend(s, i, i)
            len2 = self.centerExpend(s, i, i + 1)

            if len1 > max_len:
                max_len = len1
                res = s[i - len1 // 2 : i + len1 // 2 + 1]
            if len2 > max_len:
                max_len = len2
                res = s[i - len2 // 2 + 1 : i + len2 // 2 + 1]
        return res
        


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.longestPalindrome(s))