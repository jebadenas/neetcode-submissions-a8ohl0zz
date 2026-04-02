class Solution:
    def trap(self, height: List[int]) -> int:
        
        #have two pointers start at the same place
        #if second pointer 

        l, r = 0, len(height) - 1

        leftMax = height[l]
        rightMax = height[r]

        res=0

        while l<r:
            if leftMax < rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]

            else:
                r-= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]


        return res
