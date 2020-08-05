from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def maxHeapShiftDown(start: int) -> None:
            if not nums:
                return
            i, j = start, start * 2 + 1
            temp = nums[start]
            heapSize = len(nums)
            while j < heapSize:
                if j < heapSize - 1 and nums[j + 1] > nums[j]:
                    j += 1
                if nums[j] > temp:
                    nums[i] = nums[j]
                    i = j
                    j = i * 2 + 1
                else:
                    break
            nums[i] = temp
        def buildMaxHeap() -> None:
            heapSize = len(nums)
            for i in range(heapSize // 2 - 1, -1, -1):
                maxHeapShiftDown(i)
        def removeMax() -> int:
            t = nums[0]
            nums[0] = nums[-1]
            nums.pop()
            maxHeapShiftDown(0)
            return t

        result = 0
        buildMaxHeap()
        for i in range(k):
            result = removeMax()
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.findKthLargest(nums, k))