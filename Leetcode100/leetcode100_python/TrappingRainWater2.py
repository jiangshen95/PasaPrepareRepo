from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        result = 0
        max_left, max_right = 0, 0
        left, right = 0, len(height) - 1
        while left < right:
            if height[left] < height[right]:
                max_left = max(max_left, height[left])
                result += max_left - height[left]
                left += 1
            else:
                max_right = max(max_right, height[right])
                result += max_right - height[right]
                right -= 1
        return result

if __name__ == "__main__":
    height = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.trap(height))