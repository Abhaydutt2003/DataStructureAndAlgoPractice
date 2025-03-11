class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        map = {}
        stack = []

        def traveseNums():
            for num in nums:
                while stack and stack[-1] < num:
                    map[stack.pop()] = num
                stack.append(num)
        
        # traveseNums()
        # if stack:
        #     traveseNums()
        return [map.get(num) for num in nums]

