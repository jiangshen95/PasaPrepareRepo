from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        if amount == 0:
            return 0

        queue = [amount]
        visited = [False] * (amount + 1)
        coins.sort()
        step = 1
        while queue:
            temp = []
            for n in queue:
                for coin in coins:
                    if n - coin == 0:
                        return step
                    if n - coin < 0:
                        break
                    if not visited[n - coin]:
                        temp.append(n - coin)
                        visited[n - coin] = True
            queue = temp
            step += 1
        return -1

if __name__ == "__main__":
    coins = [int(num) for num in input().split()]
    amount = int(input())
    solution = Solution()
    print(solution.coinChange(coins, amount))