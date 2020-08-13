from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p):
            return []
        m1 = {}
        m2 = {}
        for ch in p:
            m1[ch] = m1.get(ch, 0) + 1
        
        result = []
        left, right = 0, 0
        count = 0
        while right < len(s):
            if s[right] in m1 and m2.get(s[right], 0) < m1[s[right]]:
                m2[s[right]] = m2.get(s[right], 0) + 1
                count += 1
                right += 1
            else:
                if s[right] not in m1:
                    left = right + 1
                    count = 0
                    m2.clear()
                    right += 1
                else:
                    m2[s[left]] -= 1
                    count -= 1
                    left += 1
            if count == len(p):
                result.append(left)
        return result


if __name__ == "__main__":
    s = input()
    p = input()
    solution = Solution()
    print(solution.findAnagrams(s, p))