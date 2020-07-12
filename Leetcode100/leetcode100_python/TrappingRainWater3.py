from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        result = 0
        stack = []
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                top = stack[-1]
                stack.pop()
                if not stack:
                    break
                result += (min(height[i], height[stack[-1]]) - height[top]) * \
                    (i - stack[-1] - 1)
            stack.append(i)
        return result


if __name__ == "__main__":
    height = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.trap(height))