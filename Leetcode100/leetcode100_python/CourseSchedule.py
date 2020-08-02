from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjacency = [[] for _ in range(numCourses)]
        indegrees = [0] * numCourses
        for cur, pre in prerequisites:
            adjacency[pre].append(cur)
            indegrees[cur] += 1

        queue = []
        for i in range(numCourses):
            if not indegrees[i]:
                queue.append(i)

        count = 0
        while queue:
            v = queue.pop(0)
            count += 1
            for cur in adjacency[v]:
                indegrees[cur] -= 1
                if not indegrees[cur]:
                    queue.append(cur)
        return count == numCourses

if __name__ == "__main__":
    numCourses = int(input())
    n = int(input())
    prerequisites = []
    for i in range(n):
        prerequisites.append([int(num) for num in input().split()])
    solution = Solution()
    print(solution.canFinish(numCourses, prerequisites))