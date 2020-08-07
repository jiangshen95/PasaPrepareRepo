class Solution:
    def numSquares(self, n: int) -> int:
        def isSquare(n):
            sq = int(n ** 0.5)
            return sq * sq == n
        if isSquare(n):
            return 1
        while (n & 3) == 0:
            n >>= 2
        if (n & 7) == 7:
            return 4
        for i in range(1, int(n ** 0.5) + 1, 1):
            if isSquare(n - i * i):
                return 2
        return 3

if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.numSquares(n))