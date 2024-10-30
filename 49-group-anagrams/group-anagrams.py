from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        ans = defaultdict(list)

        for str in strs:
            tmp:str = tuple(sorted(str))
            ans[tmp].append(str)

        return [values for key, values in ans.items()]
        