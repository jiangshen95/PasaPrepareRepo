from typing import List

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:

        def isValid(s):
            count = 0
            for ch in s:
                if ch == '(':
                    count += 1
                elif ch == ')':
                    count -= 1
                if count < 0:
                    return False
            return count == 0

        result = []
        queue = {s}
        while queue:
            for cur in queue:
                if isValid(cur):
                    result.append(cur)
            if result:
                break
            temp = set()
            for cur in queue:
                for i in range(len(cur)):
                    temp.add(cur[ : i] + cur[i + 1 : ])
            queue = temp
        return result
        

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.removeInvalidParentheses(s))