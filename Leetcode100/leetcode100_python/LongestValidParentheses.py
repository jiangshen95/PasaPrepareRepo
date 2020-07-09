class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        max_len = 0
        for i, ch in enumerate(s):
            if ch == '(':
                stack.append(i)
            else:
                if len(stack) > 1 and s[stack[-1]] == '(':
                    stack.pop()
                    max_len = max(max_len, i - stack[-1])
                else:
                    stack.append(i)
        return max_len

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.longestValidParentheses(s))