from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        for i in range(1 << len(nums)):
            temp = []
            for j in range(len(nums)):
                if (i >> j) & 1:
                    temp.append(nums[j])
            result.append(temp)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.subsets(nums))