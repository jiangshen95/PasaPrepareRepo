from typing import List

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        def dfs(index, target):
            if target == 0:
                return True
            if target < 0:
                return False
            for i in range(index, len(nums), 1):
                if dfs(i + 1, target - nums[i]):
                    return True
            return False
        sumAll = sum(nums)
        if (sumAll & 1) == 1:
            return False
        target = sumAll >> 1
        nums.sort(reverse=True)
        if nums[0] > target:
            return False
        return dfs(0, target)


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.canPartition(nums))