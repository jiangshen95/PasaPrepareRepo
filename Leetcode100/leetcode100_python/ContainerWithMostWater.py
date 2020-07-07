from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        begin = 0
        end = len(height) - 1
        max_area = 0
        while begin < end:
            area = (end - begin) * min(height[begin], height[end])
            max_area = max(max_area, area)
            if height[begin] < height[end]:
                begin += 1
            else:
                end -= 1
        return max_area

if __name__ == "__main__":
    height = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxArea(height))