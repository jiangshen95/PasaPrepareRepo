from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearch(left, right, target):
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left
        first = binarySearch(0, len(nums) - 1, target)
        if first >= len(nums) or nums[first] != target:
            return [-1, -1]
        second = binarySearch(first, len(nums) - 1, target + 1)
        return [first, second - 1]

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    target = int(input())
    solution = Solution()
    print(solution.searchRange(nums, target))