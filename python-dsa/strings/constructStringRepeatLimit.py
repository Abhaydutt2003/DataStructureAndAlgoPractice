import heapq
from collections import Counter

# Greedy Solution
# class Solution:
#     def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
#         freq = [0]*26
#         # populate freq
#         for char in s:
#             freq[ord(char)-ord("a")]+=1
#         result = []
#         currentIndex = 25 # start from the end
#         while currentIndex >= 0:
#             if(freq[currentIndex] == 0):
#                 currentIndex-=1
#                 continue
#             usable = min(freq[currentIndex],repeatLimit)
#             result.append(chr(currentIndex+ord("a")) * usable)
#             freq[currentIndex]-=usable
#             if(freq[currentIndex]>0):
#                 smallerCharIndex = currentIndex-1
#                 while(smallerCharIndex>=0 and freq[smallerCharIndex] == 0):
#                     smallerCharIndex-=1
#                 if(smallerCharIndex<0):
#                     break
#                 result.append(chr(smallerCharIndex+ord("a")))
#                 freq[smallerCharIndex]-=1    
#         return "".join(result)


# Can optimize even more as the set to work on grows. 



class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        maxHeap = [(-ord(c),cnt) for c,cnt in Counter(s).items()]
        heapq.heapify(maxHeap)
        while maxHeap:
            



solution_instance = Solution()
s = "cczazcc"
repeatLimit = 3
result = solution_instance.repeatLimitedString(s,repeatLimit)
print(result)