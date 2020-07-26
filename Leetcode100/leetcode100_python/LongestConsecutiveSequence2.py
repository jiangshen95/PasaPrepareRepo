from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        m = {}
        result = 0
        for num in nums:
            if num not in m:
                left = m.get(num - 1, 0)
                right = m.get(num + 1, 0)
                cur = left + right + 1
                result = max(result, cur)
                m[num] = cur
                m[num - left] = cur
                m[num + right] = cur
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.longestConsecutive(nums))