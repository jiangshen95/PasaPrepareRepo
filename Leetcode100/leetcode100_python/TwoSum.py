from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in map:
                return [map.get(diff, 0), i]
            map[num] = i
        return []


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    target = int(input())
    solution = Solution()
    print(solution.twoSum(nums, target))