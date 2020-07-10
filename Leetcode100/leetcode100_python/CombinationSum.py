from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(index, target, nums):
            if target == 0:
                result.append(nums)
                return
            if target < 0:
                return
            for i in range(index, len(candidates)):
                if target - candidates[i] < 0:
                    break
                dfs(i, target - candidates[i], nums + [candidates[i]])
        result = []
        candidates.sort()
        dfs(0, target, [])
        return result


if __name__ == "__main__":
    candidates = [int(num) for num in input().split()]
    target = int(input())
    solution = Solution()
    print(solution.combinationSum(candidates, target))