class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        dp = [0 for i in range(n)]
        max_len = 0
        for i in range(1, n):
            if s[i] == ')' and s[i - 1] == '(':
                if i > 1:
                    dp[i] = dp[i - 2] + 2
                else:
                    dp[i] = 2
            elif s[i] == ')' and s[i - 1] == ')':
                last_index = i - dp[i - 1] - 1
                if last_index >= 0 and s[last_index] == '(':
                    dp[i] = dp[i - 1] + 2
                    if last_index - 1 >= 0:
                        dp[i] += dp[last_index - 1]
            max_len = max(max_len, dp[i])
        return max_len


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.longestValidParentheses(s))