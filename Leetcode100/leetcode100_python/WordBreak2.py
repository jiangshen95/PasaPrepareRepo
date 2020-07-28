from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j : i] in wordDict:
                    dp[i] = True
                    break
        return dp[-1]

if __name__ == "__main__":
    s = input()
    n = int(input())
    wordDict= []
    for i in range(n):
        wordDict.append(input())
    solution = Solution()
    print(solution.wordBreak(s, wordDict))