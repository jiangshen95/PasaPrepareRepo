from typing import List

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        n = len(nums) - 1
        max_bit = 31
        while (n >> max_bit) == 0:
            max_bit -= 1
        
        result = 0
        for i in range(max_bit + 1):
            x, y = 0, 0
            for j in range(n + 1):
                if (nums[j] >> i) & 1:
                    x += 1
                if j > 0 and (j >> i) & 1:
                    y += 1
            if x > y:
                result |= 1 << i
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.findDuplicate(nums))