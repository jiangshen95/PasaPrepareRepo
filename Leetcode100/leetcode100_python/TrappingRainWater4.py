from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        result = 0
        n = len(height)
        max_left, max_right = 0, 0
        for i in range(n):
            max_left = max(max_left, height[i])
            max_right = max(max_right, height[n - i - 1])
            result += max_left + max_right - height[i]
        return result - max_left * n


if __name__ == "__main__":
    height = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.trap(height))