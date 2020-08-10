from typing import List

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def dfs(index, left_count, right_count, left_rem, right_rem, expression):
            if index == len(s):
                if left_rem == 0 and right_rem == 0:
                    result.add(expression)
                return
            if s[index] == '(' and left_rem > 0:
                dfs(index + 1, left_count, right_count, left_rem - 1, right_rem, expression)
            elif s[index] == ')' and right_rem > 0:
                dfs(index + 1, left_count, right_count, left_rem, right_rem - 1, expression)
            
            if s[index] != '(' and s[index] != ')':
                dfs(index + 1, left_count, right_count, left_rem, right_rem, expression + s[index])
            elif s[index] == '(':
                dfs(index + 1, left_count + 1, right_count, left_rem, right_rem, expression + s[index])
            elif right_count < left_count:
                dfs(index + 1, left_count, right_count + 1, left_rem, right_rem, expression + s[index])

        left, right = 0, 0
        for ch in s:
            if ch == '(':
                left += 1
            elif ch == ')':
                if left > 0:
                    left -= 1
                else:
                    right += 1

        result = set()
        dfs(0, 0, 0, left, right, "")
        return list(result)
        

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.removeInvalidParentheses(s))