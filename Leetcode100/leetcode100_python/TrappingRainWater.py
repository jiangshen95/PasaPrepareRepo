from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        result = 0
        n = len(height)
        max_left = [0 for _ in range(n)]
        max_right = [0 for _ in range(n)]
        for i in range(n):
            if i == 0:
                max_left[i] = height[i]
            else:
                max_left[i] = max(max_left[i - 1], height[i])
        for i in range(n - 1, -1, -1):
            if i == n - 1:
                max_right[i] = height[i]
            else:
                max_right[i] = max(max_right[i + 1], height[i])
        for i in range(n):
            result += min(max_left[i], max_right[i]) - height[i]
        return result

if __name__ == "__main__":
    height = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.trap(height))