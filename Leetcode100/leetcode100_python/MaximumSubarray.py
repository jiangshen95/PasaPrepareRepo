from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        pre = 0
        result = nums[0]
        for num in nums:
            pre = max(pre + num, num)
            result = max(result, pre)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxSubArray(nums))