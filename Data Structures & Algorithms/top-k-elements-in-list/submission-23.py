class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        freq = defaultdict()


        #count the number of occurences
        for num in nums:
            freq[num] = 1 + freq.get(num, 0);

        print(freq)

        #use an array to track the frequency of the nums (so we can traverse this later)
        occurencesArr = [[] for i in range(len(nums)+1)]
        print(occurencesArr)
        for num, count in freq.items():
        
            print(num, count)
            occurencesArr[count].append(num)

        
        #traverse occurencesArr until k elements reside in the res
        res = []
        for i in range(len(occurencesArr)-1, -1, -1):
            occurences = occurencesArr[i]
            for n in occurences:
                res.append(n)
                if len(res) == k:
                    return res
        


        