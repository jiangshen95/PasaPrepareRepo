from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        def dfs(index, combinations):
            if index == len(digits):
                result.append(combinations)
                return
            for ch in mapping[digits[index]]:
                dfs(index + 1, combinations + ch)
        if not digits:
            return []
        mapping = {
            '2': "abc",
            '3': "def",
            '4': "ghi",
            '5': "jkl",
            '6': "mno",
            '7': "pqrs",
            '8': "tuv",
            '9': "wxyz"}
        result = []
        dfs(0, "")
        return result

if __name__ == "__main__":
    digits = input()
    solution = Solution()
    print(solution.letterCombinations(digits))
        