from typing import List

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        intervals.sort(key = lambda x: x[0])
        import heapq
        heap = []
        for i in range(n):
            if heap and heap[0] <= intervals[i][0]:
                heap.pop(0)
            heapq.heappush(heap, intervals[i][1])
        return len(heap)

if __name__ == "__main__":
    nums = [int(num) for num in input().split()]
    intervals = []
    for i in range(0, len(nums), 2):
        intervals.append([nums[i], nums[i + 1]])
    solution = Solution()
    print(solution.minMeetingRooms(intervals))