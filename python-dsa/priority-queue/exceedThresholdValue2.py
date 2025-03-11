import heapq
from typing import List

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        pq = []
        for num in nums:
            heapq.heappush(pq,num)
        operations = 0
        while pq and pq[0] < k:
            newSmallest = (heapq.heappop(pq)*2)+(heapq.heappop(pq))
            heapq.heappush(pq,newSmallest)
            operations+=1
        return operations

solutionInstance = Solution()
nums = [1,1,2,4,9]
k = 20
answer = solutionInstance.minOperations(nums,k)
print(answer)