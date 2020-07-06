class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        m = {}
        j = 0
        max_len = 0
        for i, ch in enumerate(s):
            if ch in m:
                j = max(j, m[ch])
            max_len = max(max_len, i - j +1)
            m[ch] = i + 1
        return max_len

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.lengthOfLongestSubstring(s))