class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        def helper(i, j):
            if i == 0:
                return j
            if j == 0:
                return i
            
            if word1[i - 1] == word2[j - 1]:
                if remember[i - 1][j - 1] == -1:
                    remember[i - 1][j - 1] = helper(i - 1, j - 1)
                remember[i][j] = remember[i - 1][j - 1]
            else:
                if remember[i - 1][j] == -1:
                    remember[i - 1][j] = helper(i - 1, j)
                if remember[i][j - 1] == -1:
                    remember[i][j - 1] = helper(i, j - 1)
                if remember[i - 1][j - 1] == -1:
                    remember[i - 1][j - 1] = helper(i - 1, j - 1)
                remember[i][j] = min(remember[i - 1][j - 1], 
                    remember[i - 1][j], remember[i][j - 1]) + 1
            return remember[i][j]
            
        m = len(word1)
        n = len(word2)
        remember = [[-1 for _ in range(n + 1)] for __ in range(m + 1)]
        return helper(m, n)
        

if __name__ == "__main__":
    word1 = input()
    word2 = input()
    solution = Solution()
    print(solution.minDistance(word1, word2))