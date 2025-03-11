from typing import List
class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        stack = []
        for i in range(len(prices)):
            # update all the prices behind that are greater
            while (stack and prices[stack[-1]]>=prices[i]):
                toUpdate = stack.pop()
                prices[toUpdate]-=prices[i]
            stack.append(i);        
        return prices


solIns = Solution()
prices = [10,1,1,6]
result = solIns.finalPrices(prices)
print(result)