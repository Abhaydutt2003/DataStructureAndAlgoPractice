from collections import deque
from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        levelMax = root.val
        answer = []
        stack = deque([root,None])
        while stack:
            if not stack[0]:
                answer.append(levelMax)
                levelMax = float('-inf')
                stack.popleft()
                if not stack:
                    break
                else:
                    stack.append(None)
            else:
                curretNode = stack.popleft()
                if curretNode.left:
                    stack.append(curretNode.left)
                if curretNode.right:
                    stack.append(curretNode.right)
                levelMax = max(curretNode.val,levelMax) #update the currentMax
        return answer 


# class Solution:
#     def largestValues(self, root: Optional[TreeNode]) -> List[int]:
#         currentMax = root.val
#         answer,stack = [],[]
#         stack.append(root)
#         stack.append(None) # to track inorder traversal.
#         while stack:
#             if stack[0] == None:
#                 answer.append(currentMax)
#                 currentMax = -1
#                 if not stack: #check if there is anyhting to operate on 
#                     break
#                 else:
#                     stack.append(None)
#             else:
#                 currentNode = stack[0]#huge issue here,creating new lists everytime.
#                 stack = stack[1:] #remove the first element
#                 if currentNode.left:
#                     stack.append(currentNode.left)
#                 if currentNode.right:
#                     stack.append(currentNode.right)
#                 currentMax = max(currentNode.val,currentMax) #update the currentMax
#         return answer
        
# class Solution:
#     def largestValues(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return []
            
#         result = []
#         queue = deque([root])
        
#         while queue:
#             level_size = len(queue)
#             level_max = float('-inf')
            
#             # Process all nodes at current level
#             for _ in range(level_size):
#                 node = queue.popleft()
#                 level_max = max(level_max, node.val)
                
#                 # Add children to queue
#                 if node.left:
#                     queue.append(node.left)
#                 if node.right:
#                     queue.append(node.right)
            
#             result.append(level_max)
            
#         return result
