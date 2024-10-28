class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        total_sum, ans = 0, nums[0]

        for i in nums:
            
            total_sum += i

            ans = max(ans, total_sum)

            if total_sum < 0:
                total_sum = 0
        
        return ans
        