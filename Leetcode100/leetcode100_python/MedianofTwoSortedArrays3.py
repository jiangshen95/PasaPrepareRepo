from typing import List

class Solution:
    def getKthElement(self, nums1, nums2, k):
        if not nums1:
            return nums2[k - 1]
        if not nums2:
            return nums1[k - 1]
        if k == 1:
            return min(nums1[0], nums2[0])

        half = k // 2
        i1 = min(half, len(nums1)) - 1
        i2 = min(half, len(nums2)) - 1
        if nums1[i1] <= nums2[i2]:
            return self.getKthElement(nums1[i1 + 1 : ], nums2, k - i1 - 1)
        else:
            return self.getKthElement(nums1, nums2[i2 + 1 : ], k - i2 - 1)

        

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