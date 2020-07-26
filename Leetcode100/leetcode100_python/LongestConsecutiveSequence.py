from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)
        result = 0
        for num in nums:
            if num - 1 not in s:
                cur = num + 1
                while cur in s:
                    cur += 1
                result = max(result, cur - num)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.longestConsecutive(nums))