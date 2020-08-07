class Solution:
    def numSquares(self, n: int) -> int:
        def can_devided(n, count):
            if count == 1:
                return int(n ** 0.5) ** 2 == n
            i = 1
            while i * i <= n:
                if can_devided(n - i * i, count - 1):
                    return True
                i += 1
            return False

        for i in range(1, n + 1, 1):
            if can_devided(n, i):
                return i
        return 0

if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.numSquares(n))