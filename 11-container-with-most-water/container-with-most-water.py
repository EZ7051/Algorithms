class Solution:
    def maxArea(self, height: List[int]) -> int:

        ans = -sys.maxsize - 1
        i = 0
        j = len(height) - 1

        while i < j:

            if height[i] < height[j]:
                ans = max(ans, height[i]*(j-i))
                i += 1
            else:
                ans = max(ans, height[j]*(j-i))
                j -= 1
                

        return ans


        