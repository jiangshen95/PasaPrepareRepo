from typing import List

class Solution:
    def countBits(self, num: int) -> List[int]:
        bits = [0] * (num + 1)
        for i in range(num + 1):
            count = 0
            n = i
            while n:
                count += 1
                n &= n - 1
            bits[i] = count
        return bits

if __name__ == "__main__":
    num = int(input())
    solution = Solution()
    print(solution.countBits(num))