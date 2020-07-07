class Solution:
    def centerExpend(slef, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return (right - left - 1) // 2
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""

        s_ex = "#"
        for ch in s:
            s_ex += ch
            s_ex += "#"

        right = -1
        center = -1
        arm_lens = [0 for _ in range(len(s_ex))]
        ex_res = ""
        for i in range(len(s_ex)):
            if i <= right:
                min_arm_len = min(right - i, arm_lens[2 * j - i])
                cur_arm_len = self.centerExpend(s_ex, i - min_arm_len, i + min_arm_len)
            else:
                cur_arm_len = self.centerExpend(s_ex, i, i)
            
            arm_lens[i] = cur_arm_len
            if i +cur_arm_len > right:
                right = i + cur_arm_len
                j = i
            
            if cur_arm_len * 2 + 1 > len(ex_res):
                ex_res = s_ex[i - cur_arm_len: i + cur_arm_len + 1]

        return ex_res.replace("#", "")


if __name__ == "__main__":
    s = input()
    solution = Solution()
    print(solution.longestPalindrome(s))