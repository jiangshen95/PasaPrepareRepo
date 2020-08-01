from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        dp0, dp1 = nums[0], max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp0, dp1 = dp1, max(dp0 + nums[i], dp1)
        return dp1

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.rob(nums))