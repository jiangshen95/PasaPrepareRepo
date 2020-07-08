class Solution:
    def isValid(self, s: str) -> bool:
        mapping = {'(': ')', '[': ']', '{': '}'}
        stack = []
        for c in s:
            if c in mapping:
                stack.append(c)
            else:
                if not stack:
                    return False
                t = stack.pop()
                if c != mapping[t]:
                    return False
        return len(stack) == 0

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.isValid(s))