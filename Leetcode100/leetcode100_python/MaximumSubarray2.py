from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # lsum rsum isum msum
        def helper(left, right):
            if left >= right:
                return (nums[left], nums[left], nums[left], nums[left])
            mid = (left + right) // 2
            lsub = helper(left, mid)
            rsub = helper(mid + 1, right)

            lsum = max(lsub[2] + rsub[0], lsub[0])
            rsum = max(rsub[2] + lsub[1], rsub[1])
            isum = lsub[2] + rsub[2]
            msum = max(lsub[3], rsub[3], lsub[1] + rsub[0])
            return (lsum, rsum, isum, msum)
        return helper(0, len(nums) - 1)[3]

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxSubArray(nums))