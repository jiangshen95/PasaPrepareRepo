class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m = len(s)
        n = len(p)
        # 注意 m 与 n 的顺序
        dp = [[False for _ in range(n + 1)] for i in range(m + 1)]
        dp[0][0] = True

        match = lambda a, b: a == b or b == '.'

        for i in range(m + 1):
            for j in range(1, n + 1):
                if p[j - 1] != '*':
                    if i > 0 and match(s[i - 1], p[j - 1]):
                        dp[i][j] = dp[i - 1][j - 1]
                else:
                    if i > 0 and match(s[i - 1], p[j - 2]):
                        dp[i][j] = dp[i][j - 2] or dp[i - 1][j]
                    else:
                        dp[i][j] = dp[i][j - 2]

        return dp[m][n]

if __name__ == "__main__":
    s = input()
    p = input()
    solution = Solution()
    print(solution.isMatch(s, p))