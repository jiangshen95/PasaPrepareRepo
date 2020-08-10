from typing import List

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        n = len(nums) - 1
        left, right = 1, n
        while left <= right:
            mid = left + (right - left) // 2
            count = 0
            for num in nums:
                if num <= mid:
                    count += 1
            if count <= mid:
                left = mid + 1
            else:
                right = mid - 1
        return left

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findDuplicate(nums))