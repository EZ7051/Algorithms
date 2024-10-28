class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left, right, ans = [1] * (len(nums)), [1] * (len(nums)), [1] * (len(nums))

        for i in range(len(nums)):
            if i == 0:
                continue
            left[i] = left[i-1] * nums[i-1]

        
        for i in range(len(nums)-1, -1, -1):
            if i == len(nums)-1:
                continue
            right[i] = right[i+1] * nums[i+1]

        for i in range(len(nums)):
            ans[i] = left[i] * right[i]

       
        print(ans)

        return ans


            
        