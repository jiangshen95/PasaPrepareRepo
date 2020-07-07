class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if not p:
            return not s
        if len(p) == 1:
            if len(s) == 1 and (s[0] == p[0] or p[0] == '.'):
                return True
            return False
        if p[1] == '*':
            if len(s) > 0 and (s[0] == p[0] or p[0] == '.'):
                return self.isMatch(s, p[2: ]) or self.isMatch(s[1: ], p)
            else:
                return self.isMatch(s, p[2: ])
        if len(s) > 0 and (s[0] == p[0] or p[0] == '.'):
            return self.isMatch(s[1: ], p[1:])
        else:
            return False

if __name__ == "__main__":
    s = input()
    p = input()
    solution = Solution()
    print(solution.isMatch(s, p))