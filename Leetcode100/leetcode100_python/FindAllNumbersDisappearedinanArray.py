from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            if nums[i] != i + 1:
                while nums[i] != nums[nums[i] - 1]:
                    t = nums[i]
                    nums[i], nums[t - 1] = nums[t - 1], nums[i]
        result = []
        for i in range(len(nums)):
            if nums[i] != i + 1:
                result.append(i + 1)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findDisappearedNumbers(nums))