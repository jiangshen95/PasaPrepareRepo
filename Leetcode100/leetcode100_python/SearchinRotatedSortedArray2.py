from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        n = len(nums)
        left, right = 0, n - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > nums[-1]:
                left = mid + 1
            else:
                right = mid - 1

        rot = left
        l, r = 0, n - 1
        while l <= r:
            m = (l + r) // 2
            realm = (m + rot) % n
            if nums[realm] == target:
                return realm
            if nums[realm] < target:
                l = m + 1
            else:
                r = m - 1

        return -1

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    target = int(input())
    solution = Solution()
    print(solution.search(nums, target))