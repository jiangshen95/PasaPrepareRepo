from typing import List

class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        dp = {}
        dp[0] = 1
        for num in nums:
            temp = {}
            for key, value in dp.items():
                temp[key + num] = temp.get(key + num, 0) + value
                temp[key - num] = temp.get(key - num, 0) + value
            dp = temp
        return dp.get(S, 0)

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    S = int(input())
    solution = Solution()
    print(solution.findTargetSumWays(nums, S))