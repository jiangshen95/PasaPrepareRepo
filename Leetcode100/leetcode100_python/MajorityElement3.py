from typing import List

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count, candidate = 0, 0
        for num in nums:
            if count == 0:
                candidate = num
            if candidate == num:
                count += 1
            else:
                count -= 1
        return candidate

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.majorityElement(nums))