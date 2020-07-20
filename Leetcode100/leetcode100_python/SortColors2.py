from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, r = 0, 0
        for i in range(len(nums)):
            v = nums[i]
            nums[i] = 2
            if v < 2:
                nums[r] = 1
                r += 1
            if v == 0:
                nums[l] = 0
                l += 1
            
        
if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    solution.sortColors(nums)
    print(nums)