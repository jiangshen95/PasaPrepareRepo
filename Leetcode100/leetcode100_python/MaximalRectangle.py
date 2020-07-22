from typing import List

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        max_rect = 0
        heights = [0] * n
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    heights[j] += 1
                else:
                    heights[j] = 0

            max_rect = max(max_rect, self.largestRectangleArea(heights))
        return max_rect

    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        heights.append(-1)
        largest_area = 0
        for i in range(len(heights)):
            while stack and heights[i] < heights[stack[-1]]:
                top = stack.pop()
                if stack:
                    largest_area = max(largest_area, heights[top] * (i - stack[-1] - 1))
                else:
                    largest_area = max(largest_area, heights[top] * i)
            stack.append(i)
        return largest_area

if __name__ == "__main__":
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([num for num in input().split()])
    solution = Solution()
    print(solution.maximalRectangle(matrix))