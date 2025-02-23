from typing import List


class Solution:

    def appendPermutations(
        self,
        nums: List[int],
        toPopulate: List[List[int]],
        visited: List[bool] = [],
        permutation: List[int] = [],
    ) -> None:
        if len(visited) == 0:
            visited = [False] * len(nums)

        if len(permutation) == len(nums):
            toPopulate.append(permutation[:])
            return

        for i in range(len(nums)):
            if visited[i] == False:
                visited[i] = True
                permutation.append(nums[i])
                self.appendPermutations(nums, toPopulate, visited, permutation)
                visited[i] = False
                permutation.pop()

    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.appendPermutations(nums, ans, [], [])
        return ans


solution_Instance = Solution()
nums = [1, 2, 3]
ans = solution_Instance.permute(nums)
print(nums)
