from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        ans = 0
        stack = []  # monotonic
        for i in range(len(height)):
            while stack and height[stack[-1]] < height[i]:
                middle = stack.pop()
                if not stack:
                    break
                left = stack[-1]
                currentHeight = min(height[i], height[left]) - height[middle]
                width = i - left - 1
                ans += currentHeight * width
            stack.append(i)
        return ans


arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
