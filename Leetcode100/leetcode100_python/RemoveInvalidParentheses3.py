from typing import List

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def dfs(s, left, right, i_start, j_start):
            count = 0
            for i in range(i_start, len(s), 1):
                if s[i] == left:
                    count += 1
                elif s[i] == right:
                    count -= 1
                if count < 0:
                    for j in range(j_start, i + 1, 1):
                        if s[j] == right and (j == 0 or s[j - 1] != right):
                            dfs(s[ : j] + s[j + 1 : ], left, right, i, j)
                    return
            s = ''.join(reversed(s))
            if left == '(':
                dfs(s, ')', '(', 0, 0)
            else:
                result.append(s)
            

        result = []
        dfs(s, '(', ')', 0, 0)
        return result
        

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.removeInvalidParentheses(s))