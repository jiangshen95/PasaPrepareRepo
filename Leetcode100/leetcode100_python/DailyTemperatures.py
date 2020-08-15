from typing import List

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        next = {}
        n = len(T)
        result = [0] * n

        for i in range(n - 1, -1, -1):
            warmerIndex = -1
            for j in range(T[i] + 1, 101):
                if j in next:
                    warmerIndex = next[j] if warmerIndex == -1 else min(warmerIndex, next[j])
            if warmerIndex != -1:
                result[i] = warmerIndex - i
            next[T[i]] = i
        return result


if __name__ == "__main__":
    T = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.dailyTemperatures(T))