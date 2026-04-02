class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # count how many instances of element (element: count)
        fCount = {}

        #frequency array (index: frequency)
        freq = [[] for _ in range(len(nums) + 1)]

        for num in nums:
            if num in fCount:
                fCount[num] += 1
            else:
                fCount[num] = 1

        for num, count in fCount.items():
            freq[count].append(num)

        res = []

        for i in range(len(freq) - 1, 0,-1):
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    return res

        