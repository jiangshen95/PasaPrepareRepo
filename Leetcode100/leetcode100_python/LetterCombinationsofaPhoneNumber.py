from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
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
        result = [""]
        for digit in digits:
            temp = []
            for s in result:
                for ch in mapping[digit]:
                    temp.append(s + ch)
            result = temp
        return result

if __name__ == "__main__":
    digits = input()
    solution = Solution()
    print(solution.letterCombinations(digits))
        