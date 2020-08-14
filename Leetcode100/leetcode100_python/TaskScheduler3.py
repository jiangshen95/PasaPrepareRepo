from typing import List

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        dic = {}
        for ch in tasks:
            dic[ch] = dic.get(ch, 0) + 1

        heap = list(dic.values())
        heap.sort(reverse=True)

        max_val = heap[0] - 1
        idel_slots = max_val * n
        for i in range(1, len(heap)):
            idel_slots -= min(max_val, heap[i])

        return len(tasks) if idel_slots <= 0 else idel_slots + len(tasks)

if __name__ == "__main__":
    tasks = [ch for ch in input().split()]
    n = int(input())
    solution = Solution()
    print(solution.leastInterval(tasks, n))