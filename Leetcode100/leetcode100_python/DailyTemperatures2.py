from typing import List

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        n = len(T)
        result = [0] * n

        stack = []
        for i in range(n):
            while stack and T[i] > T[stack[-1]]:
                preIndex = stack.pop()
                result[preIndex] = i - preIndex
            stack.append(i)
        return result
        


if __name__ == "__main__":
    T = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.dailyTemperatures(T))