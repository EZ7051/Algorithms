class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == "": return 0
        left, right = 0, 1
        charSet = set()
        charSet.add(s[left])
        ans = 1

        while right < len(s):
            if s[right] not in charSet:
                ans = max(ans, right - left + 1)
                charSet.add(s[right])
                right += 1
            else:
                while s[right] in charSet:
                    charSet.remove(s[left])
                    left += 1
                charSet.add(s[right])
                right += 1
        
        return ans


        