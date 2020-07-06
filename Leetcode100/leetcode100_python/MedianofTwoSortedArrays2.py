from typing import List

class Solution:
    def getKthElement(self, nums1, nums2, k):
        m = len(nums1)
        n = len(nums2)
        i1, i2 = 0, 0
        while True:
            if i1 == m:
                return nums2[i2 + k - 1]
            if i2 == n:
                return nums1[i1 + k - 1]
            if k == 1:
                return min(nums1[i1], nums2[i2])
            
            mid = k // 2
            newindex1 = min(i1 + mid, m) - 1
            newindex2 = min(i2 + mid, n) - 1
            if nums1[newindex1] <= nums2[newindex2]:
                k -= newindex1 - i1 + 1
                i1 = newindex1 + 1
            else:
                k -= newindex2 - i2 + 1
                i2 = newindex2 + 1

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        if (m + n) % 2 == 1:
            return self.getKthElement(nums1, nums2, (m + n) // 2 + 1)
        else:
            return (self.getKthElement(nums1, nums2, (m + n) // 2) + 
                self.getKthElement(nums1, nums2, (m + n) // 2 + 1)) / 2

if __name__ == "__main__":
    nums1 = [int(num) for num in input().split()]
    nums2 = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findMedianSortedArrays(nums1, nums2))