from typing import List

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        dp = [0] * (n + 1)
        result = 1
        dp[result] = nums[0]
        for i in range(1, n, 1):
            if nums[i] > dp[result]:
                result += 1
                dp[result] = nums[i]
            else:
                begin, end = 1, result
                while begin <= end:
                    mid = (begin + end) // 2
                    if dp[mid] >= nums[i]:
                        end = mid - 1
                    else:
                        begin = mid + 1
                dp[begin] = nums[i]
        return result
        

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.lengthOfLIS(nums))