from typing import List

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        n = len(T)
        result = [0] * n

        for i in range(n - 1, -1, -1):
            j = i + 1
            while j < n:
                if T[j] > T[i]:
                    result[i] = j - i
                    break
                elif result[j] == 0:
                    break
                j += result[j]
        return result
        


if __name__ == "__main__":
    T = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.dailyTemperatures(T))