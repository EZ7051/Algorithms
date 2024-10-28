class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        max_e = 0
        min_e = sys.maxsize
        for i in prices:
            min_e = min(min_e, i)

            max_e = max(max_e, i - min_e)

        return max_e

        