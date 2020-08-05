from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        def getWidth(num):
            w = 0
            while num > 0:
                num &= num << 1
                w += 1
            return w

        if not matrix:
            return 0

        nums = [int(''.join(n), base=2) for n in matrix]
        n = len(nums)
        result = 0
        for i in range(n):
            temp = nums[i]
            for j in range(i, n):
                temp &= nums[j]
                if getWidth(temp) < j - i + 1:
                    break
                result = max(result, j - i + 1)
        return result ** 2


if __name__ == "__main__":
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([ch for ch in input().split()])
    solution = Solution()
    print(solution.maximalSquare(matrix))