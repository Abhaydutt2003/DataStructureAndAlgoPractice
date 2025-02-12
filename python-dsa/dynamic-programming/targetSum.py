class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        arrSum = sum(nums)
        if arrSum < target or (target+arrSum)%2 != 0:
            return 0
        