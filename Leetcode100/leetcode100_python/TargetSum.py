from typing import List

class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        def dfs(index, target):
            if index == len(nums) and target == 0:
                return 1
            if index == len(nums):
                return 0
            if (index, target) in memo:
                return memo[(index, target)]
            result = dfs(index + 1, target - nums[index]) + \
                dfs(index + 1, target + nums[index])
            memo[(index, target)] = result
            return result
        memo = {}
        return dfs(0, S)

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    S = int(input())
    solution = Solution()
    print(solution.findTargetSumWays(nums, S))