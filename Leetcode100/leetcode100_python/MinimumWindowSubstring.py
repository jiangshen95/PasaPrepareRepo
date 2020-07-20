class Solution:
    def minWindow(self, s: str, t: str) -> str:
        m = {}
        for ch in t:
            if ch in m:
                m[ch] += 1
            else:
                m[ch] = 1
        
        begin, end = 0, 0
        hasfound = 0
        result = ""
        while end < len(s):
            if s[end] in m:
                m[s[end]] -= 1
            else:
                m[s[end]] = -1
            if m[s[end]] >= 0:
                hasfound += 1
            if hasfound == len(t):
                while m[s[begin]] < 0:
                    m[s[begin]] += 1
                    begin += 1
                if not result or end - begin + 1 < len(result):
                    result = s[begin : end + 1]
                m[s[begin]] += 1
                begin += 1
                hasfound -= 1
            end += 1
        return result

if __name__ == "__main__":
    s = input()
    t = input()
    solution = Solution()
    print(solution.minWindow(s, t))