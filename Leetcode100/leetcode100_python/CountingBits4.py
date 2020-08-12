from typing import List

class Solution:
    def countBits(self, num: int) -> List[int]:
        bits = [0] * (num + 1)
        for i in range(1, num + 1, 1):
            bits[i] = bits[i & (i - 1)] + 1
        return bits

if __name__ == "__main__":
    num = int(input())
    solution = Solution()
    print(solution.countBits(num))