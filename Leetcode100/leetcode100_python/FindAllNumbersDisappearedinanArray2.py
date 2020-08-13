from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            v = abs(nums[i])
            if nums[v - 1] > 0:
                nums[v - 1] *= -1
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findDisappearedNumbers(nums))