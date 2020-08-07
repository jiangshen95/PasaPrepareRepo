from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1] * n
        for i in range(1, n):
            result[i] = result[i - 1] * nums[i - 1]
        
        right = 1
        for i in range(n - 2, -1, -1):
            right = right * nums[i + 1]
            result[i] *= right

        return result


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.productExceptSelf(nums))