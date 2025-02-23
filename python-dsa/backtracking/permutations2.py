from typing import List


class Solution:

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        visited = [False] * len(nums)
        ans = []

        def populateAns(currentPremutation: List[int]):

            if len(currentPremutation) == len(nums):
                ans.append(currentPremutation[:])
                return

            prevNum = None

            for i in range(len(nums)):

                if visited[i] or prevNum == nums[i]:
                    continue

                visited[i] = True
                currentPremutation.append(nums[i])
                populateAns(currentPremutation)
                currentPremutation.pop()
                visited[i] = False
                prevNum = nums[i]

        populateAns([])
        return ans


solutionInstance = Solution()
nums = [1, 1, 2]
ans = solutionInstance.permuteUnique(nums)
print(ans)
