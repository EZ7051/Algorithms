class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        total_p, ans = 1, nums[0]

        for i in nums:

            total_p *= i

            ans = max(ans, total_p)

            if total_p == 0:
                total_p = 1


        total_p = 1

        for i in nums[::-1]:

            total_p *= i

            ans = max(ans, total_p)

            if total_p == 0:
                total_p = 1



        return ans