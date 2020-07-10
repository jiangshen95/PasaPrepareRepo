from typing import List

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            while nums[i] > 0 and nums[i] <= n and nums[nums[i] - 1] != nums[i]:
                t = nums[i]
                nums[i], nums[t - 1] = nums[t - 1], nums[i]
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1
        return n + 1

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.firstMissingPositive(nums))