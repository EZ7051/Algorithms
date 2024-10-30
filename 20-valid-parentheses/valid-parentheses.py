class Solution:
    def isValid(self, s: str) -> bool:

        stk = []

        for c in s:
            if c == ')':
                if len(stk) == 0 or stk.pop() != '(':
                    return False
            elif c =='}':
                if len(stk) == 0 or stk.pop() != '{':
                    return False
            elif c ==']':
                if len(stk) == 0 or stk.pop() != '[':
                    return False
            else:
                stk.append(c)
        
        return len(stk) == 0

        