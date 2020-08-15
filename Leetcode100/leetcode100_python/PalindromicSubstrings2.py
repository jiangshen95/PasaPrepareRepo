class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        count = 0

        dp = [[False for _ in range(n)] for __ in range(n)]

        for j in range(n):
            for i in range(j, -1, -1):
                if s[i] == s[j]:
                    if j - i <= 1:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]
                    if dp[i][j]:
                        count += 1
        return count


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.countSubstrings(s))