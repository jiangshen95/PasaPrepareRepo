from typing import List

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        def helper(begin: int, end: int) -> int:
            if begin == end:
                return nums[begin]
            mid = (begin + end) // 2
            left = helper(begin, mid)
            right = helper(mid + 1, end)

            if left == right:
                return left
            
            if(nums.count(left) > nums.count(right)):
                return left
            else:
                return right
        return helper(0, len(nums) - 1)

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.majorityElement(nums))