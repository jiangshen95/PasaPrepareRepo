class Solution:
    def climbStairs(self, n: int) -> int:
        p, q, r = 1, 1, 1
        for i in range(2, n + 1):
            r = p + q
            p = q
            q = r
        return r

if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.climbStairs(n))