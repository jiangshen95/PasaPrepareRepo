from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        begin, end = 0, len(nums) - 1
        i = 0
        while i <= end:
            if nums[i] == 0:
                nums[i], nums[begin] = nums[begin], nums[i]
                i += 1
                begin += 1
            elif nums[i] == 2:
                nums[i], nums[end] = nums[end], nums[i]
                end -= 1
            else:
                i += 1
        
if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    solution.sortColors(nums)
    print(nums)