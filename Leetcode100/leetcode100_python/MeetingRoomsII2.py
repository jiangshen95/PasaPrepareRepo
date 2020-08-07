from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        starts, ends = [], []
        for i in range(n):
            starts.append(intervals[i][0])
            ends.append(intervals[i][1])
        starts.sort()
        ends.sort()
        result = 0
        j = 0
        for i in range(n):
            if starts[i] < ends[j]:
                result += 1
            else:
                j += 1
        return result

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    intervals = []
    for i in range(0, len(nums), 2):
        intervals.append([nums[i], nums[i + 1]])
    solution = Solution()
    print(solution.minMeetingRooms(intervals))