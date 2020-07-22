from typing import List

class Solution:
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
    heights = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.largestRectangleArea(heights))