from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        if m > n:
            nums1, nums2 = nums2, nums1
            m, n = n, m
        
        begin = 0
        end = m
        while begin <= end:
            i = (begin + end) // 2
            j = (m + n + 1) // 2 - i
            if i > begin and nums1[i - 1] > nums2[j]:
                end = i - 1
            elif i < end and nums2[j - 1] > nums1[i]:
                begin = i + 1
            else:
                max_left = 0
                if i == 0:
                    max_left = nums2[j - 1]
                elif j == 0:
                    max_left = nums1[i - 1]
                else:
                    max_left = max(nums1[i - 1], nums2[j - 1])
                if (m + n) % 2 == 1:
                    return max_left
                
                min_right = 0
                if i == m:
                    min_right = nums2[j]
                elif j == n:
                    min_right = nums1[i]
                else:
                    min_right = min(nums1[i], nums2[j])
                return (max_left + min_right) / 2

        return 0

if __name__ == "__main__":
    nums1 = [int(num) for num in input().split()]
    nums2 = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findMedianSortedArrays(nums1, nums2))