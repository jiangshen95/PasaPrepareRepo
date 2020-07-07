class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        n = len(s)
        dp = [[0 for _ in range(n)] for i in range(n)]
        for i in range(n):
            dp[i][i] = 1
        max_len = 0
        res = s[0:1]
        for i in range(n):
            for j in range(0, i):
                if s[i] == s[j]:
                    if i == j + 1:
                        dp[j][i] = 2
                    elif dp[j + 1][i  -1] > 0:
                        dp[j][i] = dp[j + 1][i - 1] + 2
                    if dp[j][i] > max_len:
                        max_len = dp[j][i]
                        res = s[j: i + 1]
        return res


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.longestPalindrome(s))