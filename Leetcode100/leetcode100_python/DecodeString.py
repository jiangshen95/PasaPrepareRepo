class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        result = ""
        repeat = 0
        for ch in s:
            if ch == '[':
                stack.append((repeat, result))
                result = ""
                repeat = 0
            elif ch == ']':
                cur_repeat, last_result = stack.pop()
                result = last_result + cur_repeat * result
            elif '0' <= ch <= '9':
                repeat = repeat * 10 + int(ch)
            else:
                result += ch
        return result

if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.decodeString(s))