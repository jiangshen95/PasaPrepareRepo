from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        min_price = 1 << 32
        for price in prices:
            min_price = min(min_price, price)
            result = max(result, price - min_price)
        return result

if __name__ == "__main__":
    prices = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxProfit(prices))