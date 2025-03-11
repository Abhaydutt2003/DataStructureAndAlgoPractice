from typing import List
class Solution:




    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        map = {}
        stack = []
        for num in nums2:
            while stack and stack[-1]<num:
                map[stack.pop()] = num
            stack.append(num)    
        ans = [map.get(num,-1)for num in nums1]    
        return ans                  
                 
solution_instance = Solution()
# nums1 = [1,3,5,2,4]
# nums2 = [6,5,4,3,2,1,7]
nums1 = [4,1,2]
nums2 = [1,3,4,2]
result = solution_instance.nextGreaterElement(nums1,nums2)
print(result)