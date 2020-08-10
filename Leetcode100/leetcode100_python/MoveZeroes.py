from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                if i > index:
                    nums[index] = nums[i]
                    nums[i] = 0
                index += 1

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    solution.moveZeroes(nums)
    print(nums)