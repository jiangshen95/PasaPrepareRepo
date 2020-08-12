from typing import List

class Solution:
    def countBits(self, num: int) -> List[int]:
        bits = [0] * (num + 1)
        i, b = 0, 1
        while b <= num:
            while i < b and i + b <= num:
                bits[i + b] = bits[i] + 1
                i += 1
            i = 0
            b <<= 1
        return bits

if __name__ == "__main__":
    num = int(input())
    solution = Solution()
    print(solution.countBits(num))