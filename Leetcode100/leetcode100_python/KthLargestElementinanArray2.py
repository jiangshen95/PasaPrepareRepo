from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def partition(begin: int, end: int) -> int:
            if begin >= end:
                return nums[begin]
            import random
            rand = random.randint(begin, end)
            nums[begin], nums[rand] = nums[rand], nums[begin]
            v = nums[begin]
            i, j = begin, end
            while i < j:
                while i < j and nums[j] <= v:
                    j -= 1
                nums[i] = nums[j]
                while i < j and nums[i] >= v:
                    i += 1
                nums[j] = nums[i]
            nums[i] = v
            if i + 1 == k:
                return v
            elif i + 1 < k:
                return partition(i + 1, end)
            else:
                return partition(begin, i - 1)
        return partition(0, len(nums) - 1)

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.findKthLargest(nums, k))