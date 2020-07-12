from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        step = 0
        end = 0
        max_position = 0
        for i in range(n - 1):
            max_position = max(max_position, nums[i] + i)
            if i == end:
                step += 1
                end = max_position
        return step

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.jump(nums))