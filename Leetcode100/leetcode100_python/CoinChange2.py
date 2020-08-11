from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def dfs(index, amount, count):
            nonlocal result
            if amount == 0:
                result = min(result, count)
            if index == len(coins):
                return
            
            k = amount // coins[index]
            while k >= 0 and count + k < result:
                dfs(index + 1, amount - coins[index] * k, count + k)
                k -= 1
                
        result = float('inf')
        coins.sort(key = lambda x : -x)
        dfs(0, amount, 0)
        return -1 if result == float('inf') else result

if __name__ == "__main__":
    coins = [int(num) for num in input().split()]
    amount = int(input())
    solution = Solution()
    print(solution.coinChange(coins, amount))