from typing import List

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        dic = {}
        for ch in tasks:
            dic[ch] = dic.get(ch, 0) + 1
        import heapq
        heap = [-num for num in dic.values()]
        heapq.heapify(heap)
        time = 0
        while heap:
            temp = []
            i = 0
            while i <= n:
                if heap:
                    if abs(heap[0]) > 1:
                        temp.append(abs(heapq.heappop(heap)) - 1)
                    else:
                        heapq.heappop(heap)
                time += 1
                if not heap and not temp:
                    break
                i += 1
            for num in temp:
                heapq.heappush(heap, -num)
        return time

if __name__ == "__main__":
    tasks = [ch for ch in input().split()]
    n = int(input())
    solution = Solution()
    print(solution.leastInterval(tasks, n))