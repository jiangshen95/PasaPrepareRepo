class Solution:
    def numTrees(self, n: int) -> int:
        def helper(n):
            if n <= 1:
                return 1
            if mem[n] != 0:
                return mem[n]
            for i in range(n):
                mem[n] += helper(i) * helper(n - i - 1)
            return mem[n]

        mem = [0] * (n + 1)
        return helper(n)

if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.numTrees(n))