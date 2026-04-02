class Solution:
    def maxArea(self, heights: List[int]) -> int:
        
        curMax = 0

        l, r = 0, len(heights) - 1

        while l < r:
            height = min(heights[l], heights[r])
            width = r-l

            area= height*width
            curMax = max(curMax,area)

            if heights[l] < heights[r]:
                l+=1
            elif heights[l] > heights[r]:
                r-=1
            else:
                l+=1

    

        return curMax