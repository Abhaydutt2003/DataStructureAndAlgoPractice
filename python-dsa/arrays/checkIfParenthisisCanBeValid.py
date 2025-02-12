class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        if len(s) %2 != 0:
            return False
        open = []
        unlocked = []
        for i in range(len(s)):
            if locked[i] == '0':
                unlocked.append(i)
            elif s[i] == '(':
                open.append(i)
            elif s[i] == ")":
                if open:
                    open.pop()
                elif unlocked:
                    unlocked.pop()
                else:
                    return False
        while open and unlocked and open[-1] < unlocked[-1]:            
            open.pop()
            unlocked.pop()
        if open or len(unlocked)%2 != 0:
            return False
        else:
            return True
        




    # def canBeValid(self, s: str, locked: str) -> bool:
    #     numZero,numOnes = 0,0
    #     for i in range(len(s)):
    #         if locked[i] == "0":
    #             if numOnes :
    #                 numOnes -= 0
    #             else:
    #                 numZero += 1
    #         else:
    #             if s[i] == "(":
    #                 numOnes+=1
    #             else:
    #                 if numZero :
    #                     numZero-=1
    #                 else:
    #                     numOnes+=1
    #     return numZero%2 ==0 and numOnes == 0

solution_instance = Solution()
s = "))()))" 
locked = "010100"
answer = solution_instance.canBeValid(s,locked)
print(answer)