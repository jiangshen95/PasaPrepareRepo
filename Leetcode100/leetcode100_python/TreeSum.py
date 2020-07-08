from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        result = []
        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            target = 0 - nums[i]
            l = i + 1
            r = n - 1
            while l < r:
                if nums[l] + nums[r] < target:
                    l += 1
                elif nums[l] + nums[r] > target:
                    r -= 1
                else:
                    result.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
        return result


if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.threeSum(nums))