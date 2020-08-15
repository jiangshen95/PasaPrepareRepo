class Solution:
    def countSubstrings(self, s: str) -> int:
        def manachers(s):
            s_ex = "@#"
            s_ex += "#".join(s)
            s_ex += "#$"
            
            n = len(s_ex)
            lens = [0] * n
            center, right = 0, 0
            for i in range(1, n - 1):
                if i < right:
                    lens[i] = min(right - i, lens[2 * center - i])
                while s_ex[i + lens[i] + 1] == s_ex[i - lens[i] - 1]:
                    lens[i] += 1
                if i + lens[i] > right:
                    center, right = i, i + lens[i]
            return lens
        return sum([(l + 1) // 2 for l in manachers(s)])


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.countSubstrings(s))