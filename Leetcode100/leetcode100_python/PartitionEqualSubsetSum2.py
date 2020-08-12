from typing import List

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        sumAll = sum(nums)
        if (sumAll & 1) == 1:
            return False
        target = sumAll >> 1
        dp = [[False for _ in range(target + 1)] for __ in range(len(nums))]
        for i in range(len(nums)):
            if nums[i] <= target:
                dp[i][nums[i]] = True
            else:
                return False
            for j in range(nums[i] + 1, target + 1, 1):
                if i > 0:
                    dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
        return dp[-1][-1]


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.canPartition(nums))