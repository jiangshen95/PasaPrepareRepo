from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        dp = []
        dp.append([""])
        
        for i in range(1, n + 1):
            cur = []
            for j in range(i):
                for left in dp[j]:
                    for right in dp[i - j - 1]:
                        cur.append("(" + left + ")" + right)
            dp.append(cur)

        return dp[n]


if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.generateParenthesis(n))