from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        def dfs(v: int) -> bool:
            if flags[v] == -1:
                return True
            if flags[v] == 1:
                return False
            flags[v] = 1
            for node in adjacency[v]:
                if not dfs(node):
                    return False
            flags[v] = -1
            return True

        adjacency = [[] for _ in range(numCourses)]
        for cur, pre in prerequisites:
            adjacency[pre].append(cur)

        flags = [0] * numCourses
        for i in range(numCourses):
            if not dfs(i):
                return False
        return True

if __name__ == "__main__":
    numCourses = int(input())
    n = int(input())
    prerequisites = []
    for i in range(n):
        prerequisites.append([int(num) for num in input().split()])
    solution = Solution()
    print(solution.canFinish(numCourses, prerequisites))