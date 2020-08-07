from typing import List

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        result = []
        deque = []
        for i in range(n):
            if deque and deque[0] <= i - k:
                deque.pop(0)
            while deque and nums[deque[-1]] < nums[i]:
                deque.pop()
            deque.append(i)
            if i >= k - 1:
                result.append(nums[deque[0]])
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.maxSlidingWindow(nums, k))