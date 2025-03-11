import heapq
from typing import List

class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        pq = []
        # add all the elements in the pq
        for i in range(len(nums)):
            pq.append([nums[i], i])
        heapq.heapify(pq)    
        
        return pq  

solution_instance = Solution()
nums = [2,1,3,5,6]
k = 5, 
multiplier = 2
result = solution_instance.getFinalState(nums,k,multiplier)
print(result)