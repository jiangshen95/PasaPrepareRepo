class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0
        n = len(s)
        for center in range(2 * n - 1):
            left = center >> 1
            right = left + center % 2
            while left >= 0 and right < n and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1
        return count


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.countSubstrings(s))