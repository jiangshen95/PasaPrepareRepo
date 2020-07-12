from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def helper(nums, first):
            if first == len(nums):
                result.append(nums.copy())
                return
            for i in range(first, len(nums)):
                nums[i], nums[first] = nums[first], nums[i]
                helper(nums, first + 1)
                nums[i], nums[first] = nums[first], nums[i]

        result = []
        helper(nums, 0)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.permute(nums))