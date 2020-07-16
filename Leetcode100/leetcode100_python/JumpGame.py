from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_position = 0
        for i, num in enumerate(nums):
            if i > max_position:
                return False
            max_position = max(max_position, num + i)
            if max_position >= len(nums) - 1:
                return True
        return False

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.canJump(nums))