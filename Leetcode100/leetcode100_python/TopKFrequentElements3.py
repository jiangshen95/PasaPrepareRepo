from typing import List
import collections
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = {}
        for num in nums:
            counts[num] = counts.get(num, 0) + 1
        
        buckets = [[] for _ in range(len(nums) + 1)]
        for key, count in counts.items():
            buckets[count].append(key)
        
        result = []
        for i in range(len(nums), 0, -1):
            if buckets[i]:
                result.extend(buckets[i])
            if len(result) >= k:
                break

        return result[ : k]


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.topKFrequent(nums, k))