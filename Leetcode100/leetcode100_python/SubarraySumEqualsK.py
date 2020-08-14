from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixSum = {0: 1}
        result = 0
        cur_sum = 0
        for num in nums:
            cur_sum += num
            result += prefixSum.get(cur_sum - k, 0)
            prefixSum[cur_sum] = prefixSum.get(cur_sum, 0) + 1
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    k = int(input())
    solution = Solution()
    print(solution.subarraySum(nums, k))