from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        buy, sell, pre_buy, pre_sell = 0, 0, 0, 0
        for i in range(len(prices)):
            if i == 0:
                buy = -prices[i]
            else:
                pre_buy = buy
                buy = max(pre_buy, pre_sell - prices[i])
                pre_sell = sell
                sell = max(pre_sell, pre_buy + prices[i])
        return sell

if __name__ == "__main__":
    prices = [int(num) for num in input().split()]
    solution = Solution()
    print(solution.maxProfit(prices))