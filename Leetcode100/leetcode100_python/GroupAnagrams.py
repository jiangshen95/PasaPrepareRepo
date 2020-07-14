from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = {}
        for s in strs:
            key = tuple(sorted(s))
            if key in m:
                m[key].append(s)
            else:
                m[key] = [s]
        return list(m.values())[0]


if __name__ == "__main__":
    inputs = input()
    strs = inputs.split()
    solution = Solution()
    print(strs)
    print(solution.groupAnagrams(strs))