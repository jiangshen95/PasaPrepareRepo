from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        prefix, suffix = 0, 0
        result = float('-inf')
        for i in range(len(nums)):
            prefix = prefix * nums[i] if prefix else nums[i]
            suffix = suffix * nums[len(nums) - i - 1] if suffix else nums[len(nums) - i - 1]
            result = max(result, prefix, suffix)
        return result


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxProduct(nums))