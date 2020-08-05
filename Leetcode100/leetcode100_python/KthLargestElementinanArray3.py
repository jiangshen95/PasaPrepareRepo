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

            i = begin
            for j in range(begin + 1, end + 1):
                if nums[j] > v:
                    i += 1
                    nums[i], nums[j] = nums[j], nums[i]
            nums[begin], nums[i] = nums[i], nums[begin]
            return i

        begin, end = 0, len(nums) - 1
        while True:
            index = partition(begin, end)
            if index + 1 == k:
                return nums[index]
            elif index + 1 < k:
                begin = index + 1
            else:
                end = index - 1
        return 0

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.findKthLargest(nums, k))