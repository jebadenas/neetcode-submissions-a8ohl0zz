class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        difIndex = {}

        for i in range(len(nums)):
            num = nums[i]

            if num in difIndex:
                return [difIndex[num], i]


            dif = target - num
            difIndex[dif] = i

        return
