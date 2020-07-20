from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def helper(cur, index):
            result.append(cur)
            for i in range(index, len(nums)):
                helper(cur + [nums[i]], i + 1)
        result = []
        helper([], 0)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.subsets(nums))