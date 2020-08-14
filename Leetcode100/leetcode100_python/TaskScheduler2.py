from typing import List

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        dic = {}
        for ch in tasks:
            dic[ch] = dic.get(ch, 0) + 1

        heap = list(dic.values())
        heap.sort(reverse=True)

        max_val = heap[0]
        time = (max_val - 1) * (n + 1)
        i = 0
        while i < len(heap) and heap[i] == max_val:
            i += 1
        time += i

        return max(time, len(tasks))

if __name__ == "__main__":
    tasks = [ch for ch in input().split()]
    n = int(input())
    solution = Solution()
    print(solution.leastInterval(tasks, n))