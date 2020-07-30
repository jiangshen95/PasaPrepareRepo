from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        result, dp_min, dp_max = nums[0], nums[0], nums[0]
        for num in nums[1:]:
            if num < 0:
                dp_max, dp_min = dp_min, dp_max
            dp_max = max(dp_max * num, num)
            dp_min = min(dp_min * num, num)
            result = max(result, dp_max)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxProduct(nums))