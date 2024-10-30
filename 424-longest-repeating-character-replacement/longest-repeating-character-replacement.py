class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l= 0
        mp = {}
        n = len(s)
        ans = 0
        maxf = 0

        for r in range(n):
            mp[s[r]] = mp.get(s[r], 0) + 1

            maxf = max(maxf, mp[s[r]])

            if (r - l + 1) - maxf > k:
                mp[s[l]] -= 1
                l += 1

            ans = max(ans, r - l + 1)

        return ans




        