from typing import List

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        result = []
        left = [0] * n
        right = [0] * n
        for i in range(n):
            if i % k == 0:
                left[i] = nums[i]
            else:
                left[i] = max(left[i - 1], nums[i])
            j = n - i - 1
            if j % k == 0 or j == n - 1:
                right[j] = nums[j]
            else:
                right[j] = max(right[j + 1], nums[j])
        
        for i in range(0, n - k + 1):
            result.append(max(right[i], left[i + k - 1]))
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.maxSlidingWindow(nums, k))