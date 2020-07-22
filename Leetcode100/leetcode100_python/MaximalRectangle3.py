from typing import List

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        max_rect = 0

        left = [0] * n
        right = [n] * n
        heights = [0] * n

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    heights[j] += 1
                else:
                    heights[j] = 0

            cur_left = 0
            for j in range(n):
                if matrix[i][j] == '1':
                    left[j] = max(left[j], cur_left)
                else:
                    cur_left = j + 1
                    left[j] = 0
            
            cur_right = n
            for j in range(n - 1, -1, -1):
                if matrix[i][j] == '1':
                    right[j] = min(right[j], cur_right)
                else:
                    cur_right = j
                    right[j] = n

            for j in range(n):
                max_rect = max(max_rect, heights[j] * (right[j] - left[j]))

        return max_rect

if __name__ == "__main__":
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([num for num in input().split()])
    solution = Solution()
    print(solution.maximalRectangle(matrix))