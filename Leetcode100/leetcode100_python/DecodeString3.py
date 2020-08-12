import re

class Solution:
    def decodeString(self, s: str) -> str:
        while '[' in s:
            s = re.sub(r'(\d+)\[([a-z,A-Z]*)\]', lambda m : int(m.group(1)) * m.group(2), s)
        return s

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.decodeString(s))