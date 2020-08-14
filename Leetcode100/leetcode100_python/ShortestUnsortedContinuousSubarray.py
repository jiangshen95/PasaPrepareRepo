from typing import List

class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return 0
        left, right = n - 2, 1
        cur_min, cur_max = nums[-1], nums[0]
        up, down = 0, 1
        while left >= 0 and right < n:
            if nums[left] > cur_min:
                down = left
            else:
                cur_min = nums[left]
            if nums[right] < cur_max:
                up = right
            else:
                cur_max = nums[right]
            left -= 1
            right += 1
        return up - down + 1

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findUnsortedSubarray(nums))