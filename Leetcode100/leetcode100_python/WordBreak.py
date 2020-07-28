from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        def helper(s):
            if not s:
                return True
            if s in mem:
                return mem[s]
            result = False
            for i in range(len(s)):
                if s[: i + 1] in wordDict:
                    result |= helper(s[i + 1 :])
            mem[s] = result
            return result
        mem = {}
        return helper(s)

if __name__ == "__main__":
    s = input()
    n = int(input())
    wordDict= []
    for i in range(n):
        wordDict.append(input())
    solution = Solution()
    print(solution.wordBreak(s, wordDict))