from typing import List


class Solution:
    def calcNumSum(self,num:int)->int:
        sum = 0
        while num > 0 :
            sum += num%10
            num = int(num/10)
        return sum
    
    def maximumSum(self, nums: List[int]) -> int:
        digitSumMap = {}
        for num in nums:
            digitSum = self.calcNumSum(num)
            if digitSum not in digitSumMap:
                digitSumMap[digitSum] = []
            digitSumMap[digitSum].append(num)
        largestSum = -1    
        for key in digitSumMap:
            digitSumMap.get(key).sort()
            currentList = digitSumMap.get(key)
            if len(currentList) >= 2:
                currentSum = currentList[-1] + currentList[-2]
                largestSum = max(largestSum,currentSum)
        return largestSum
solution_instance = Solution()
nums = [229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401]
answer = solution_instance.maximumSum(nums)
print(answer)