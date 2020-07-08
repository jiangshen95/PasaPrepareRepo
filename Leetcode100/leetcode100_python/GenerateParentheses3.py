from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        if n == 0:
            return [""]
        for i in range(n):
            for left in self.generateParenthesis(i):
                for right in self.generateParenthesis(n - i - 1):
                    result.append("(" + left + ")" + right)
        return result


if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.generateParenthesis(n))