class Solution:
    def decodeString(self, s: str) -> str:
        def dfs(s, i):
            result = ""
            repeat = 0
            while i < len(s):
                if '0' <= s[i] <= '9':
                    repeat = repeat * 10 + int(s[i])
                elif s[i] == '[':
                    i, temp = dfs(s, i + 1)
                    result += repeat * temp
                    repeat = 0
                elif s[i] == ']':
                    return (i, result)
                else:
                    result += s[i]
                i += 1
            return result
        return dfs(s, 0)

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.decodeString(s))