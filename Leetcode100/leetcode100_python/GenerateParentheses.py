from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def dfs(left, right, s):
            if left == n and right == n:
                result.append(s)
                return
            if left < n:
                dfs(left + 1, right, s + "(")
            if left > right:
                dfs(left, right + 1, s + ")")
        result = []
        dfs(0, 0, "")
        return result


if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.generateParenthesis(n))