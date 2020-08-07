class Solution:
    def numSquares(self, n: int) -> int:
        result = 0
        queue = {n}
        while queue:
            temp = set()
            result += 1
            for num in queue:
                i = 1
                while i * i <= num:
                    if i * i == num:
                        return result
                    else:
                        temp.add(num - i * i)
                    i += 1
            queue = temp
        return result

if __name__ == "__main__":
    n = int(input())
    solution = Solution()
    print(solution.numSquares(n))