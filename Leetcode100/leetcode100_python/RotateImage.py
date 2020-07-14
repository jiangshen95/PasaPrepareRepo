from typing import List

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n // 2):
            matrix[i], matrix[n - i - 1] = matrix[n - i - 1], matrix[i]
        
        for i in range(n):
            for j in range(i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        

if __name__ == "__main__":
    n = int(input())
    matrix = []
    for i in range(n):
        nums = [int(num) for num in input().split()]
        matrix.append(nums)
    solution = Solution()
    solution.rotate(matrix)
    print(matrix)