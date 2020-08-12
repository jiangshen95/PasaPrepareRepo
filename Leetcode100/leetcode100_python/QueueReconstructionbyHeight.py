from typing import List

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda p : (-p[0], p[1]))
        result = []
        for p in people:
            result.insert(p[1], p)
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    people = []
    for i in range(0, len(nums), 2):
        people.append([nums[i], nums[i +1]])
    solution = Solution()
    print(solution.reconstructQueue(people))