class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        if amount == 0: return 0
        if amount < 0: return sys.maxsize

        dp = [sys.maxsize] * (amount + 1)

        dp[0] = 0
        for amt in range(1, amount+1):
            for coin in coins:
                if amt >= coin and dp[amt - coin] != sys.maxsize:
                    dp[amt] = min(dp[amt], 1 + dp[amt - coin])

        if dp[amount] == sys.maxsize :
            return -1

        return dp[amount]

        