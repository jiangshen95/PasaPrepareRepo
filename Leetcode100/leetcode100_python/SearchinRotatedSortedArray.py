from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left, right = 0, n - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[0]:
                if target >= nums[0] and nums[mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target <= nums[-1] and nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    target = int(input())
    solution = Solution()
    print(solution.search(nums, target))