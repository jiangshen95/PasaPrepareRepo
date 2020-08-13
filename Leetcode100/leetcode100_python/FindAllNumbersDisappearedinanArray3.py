from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        return list(set(range(1, len(nums) + 1)) - set(nums))

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findDisappearedNumbers(nums))