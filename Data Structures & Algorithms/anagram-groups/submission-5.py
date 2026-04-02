class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        #map the count of each charater to an array of words (anagrams)

        res = {}

        for s in strs:

            count = [0] * 26 #[countofA, countofB, ...]

            for c in s:
                index = ord(c) - ord("a") #we calculate index relative to a ascii value
                count[index] += 1
            
            if tuple(count) in res:
                res[tuple(count)].append(s)
            else:
                res[tuple(count)] = [s]

        return res.values()
        