class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = {}
        for index, ele in enumerate(nums):
            if ele in mp:
                mp[ele].append(index)
            else:
                mp[ele] = [index]

        for key, val in mp.items():
            compliment = target - key
            if compliment in mp:
                if len(mp[compliment]) > 1:
                    return mp[compliment][0], mp[compliment][1]
                elif mp[compliment][0] != val[0]:
                    return val[0], mp[compliment][0]
