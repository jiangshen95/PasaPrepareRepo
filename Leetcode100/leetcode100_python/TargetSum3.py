from typing import List

class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:

        sumAll = sum(nums)
        if S > sumAll or ((sumAll + S) & 1) == 1:
            return 0
        return self.subsetSum(nums, (sumAll + S) >> 1)

    def subsetSum(self, nums: List[int], target: int) -> int:
        dp = [0] * (target + 1)
        dp[0] = 1
        for num in nums:
            for j in range(target, num - 1, -1):
                dp[j] += dp[j - num]
        return dp[target]

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    S = int(input())
    solution = Solution()
    print(solution.findTargetSumWays(nums, S))