from typing import List

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        sumAll = sum(nums)
        if (sumAll & 1) == 1:
            return False
        target = sumAll >> 1
        dp = [False] * (target + 1)
        dp[0] = True
        for i in range(len(nums)):
            for j in range(target, nums[i] - 1, -1):
                if dp[target]:
                    return True
                dp[j] = dp[j] or dp[j - nums[i]]
        return dp[-1]


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.canPartition(nums))