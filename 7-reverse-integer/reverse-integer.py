class Solution:
    def reverse(self, x: int) -> int:
        if x ==0 : return 0
        rev_str:str = ""

        tmp = abs(x)

        while( tmp > 0 ):
            rev_str += str(tmp % 10)
            tmp = int(tmp / 10)

        ans = int(rev_str)

        if x < 0 :
            ans *= -1

        if ans > 2**31 -1 or ans < -2**31:
            return 0
        return ans
