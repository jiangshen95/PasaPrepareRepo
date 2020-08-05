from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        import heapq
        return heapq.nlargest(k, nums)[-1]

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.findKthLargest(nums, k))