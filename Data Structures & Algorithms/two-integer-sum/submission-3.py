class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        pairs = {}


        for i in range(len(nums)):
            current = nums[i]
            required = target - current

            if required in pairs:
                return [pairs[required], i]
            pairs[current] = i

        
        