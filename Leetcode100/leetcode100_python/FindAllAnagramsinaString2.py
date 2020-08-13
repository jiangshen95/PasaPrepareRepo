from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p):
            return []
        m = [0] * 26
        for ch in p:
            m[ord(ch) - ord('a')] += 1
        
        result = []
        left, right = 0, 0
        count = 0
        while right < len(s):
            cur = ord(s[right]) - ord('a')
            m[cur] -= 1
            if m[cur] >= 0:
                count += 1
            right += 1
            if count == len(p):
                result.append(left)
            if right - left == len(p):
                if m[ord(s[left]) - ord('a')] >= 0:
                    count -= 1
                m[ord(s[left]) - ord('a')] += 1
                left += 1
        return result


if __name__ == "__main__":
    s = input()
    p = input()
    solution = Solution()
    print(solution.findAnagrams(s, p))