class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        max_len = 0
        left, right = 0, 0
        for i in range(n):
            if s[i] == '(':
                left += 1
            else:
                right += 1
            if left == right:
                max_len = max(max_len, 2 * left)
            elif left < right:
                left = 0
                right = 0

        left, right = 0, 0
        for i in range(n - 1, -1, -1):
            if s[i] == '(':
                left += 1
            else:
                right += 1
            if left == right:
                max_len = max(max_len, 2 * left)
            elif right < left:
                left = 0
                right = 0
        return max_len


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.longestValidParentheses(s))