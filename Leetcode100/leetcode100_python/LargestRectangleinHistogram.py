from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        n = len(heights)
        left_less = [-1 for _ in range(n)]
        right_less = [n for _ in range(n)]
        for i in range(1, n):
            k = i - 1
            while k >= 0 and heights[k] >= heights[i]:
                k = left_less[k]
            left_less[i] = k
        for i in range(n - 2, -1, -1):
            k = i + 1
            while k < n and heights[k] >= heights[i]:
                k = right_less[k]
            right_less[i] = k
        larest_area = 0
        for i in range(n):
            larest_area = max(larest_area, heights[i] * (right_less[i] - left_less[i] - 1))
        return larest_area

if __name__ == "__main__":
    heights = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.largestRectangleArea(heights))