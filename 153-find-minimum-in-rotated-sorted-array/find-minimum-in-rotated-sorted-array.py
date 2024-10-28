class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums[0] < nums[-1]: return nums[0]

        left, right, mid = 0, len(nums) - 1, 0

        while(left < right): 

            mid = (right - left) // 2 + left

            if nums[left] > nums[mid]:
                right = right - 1
            else:
                left = left + 1

        

        return nums[left]
        