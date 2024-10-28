class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = {}

        for idx, val in enumerate(nums):
            compliment = target - val

            if compliment in mp:
                return mp[compliment], idx
            else:
                mp[val] = idx
        