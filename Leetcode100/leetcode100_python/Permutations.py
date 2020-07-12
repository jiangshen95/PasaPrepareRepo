from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def helper(nums, temp):
            if not nums:
                result.append(temp)
                return
            for i in range(len(nums)):
                helper(nums[: i] + nums[i + 1 : ], temp + [nums[i]])

        result = []
        helper(nums, [])
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.permute(nums))