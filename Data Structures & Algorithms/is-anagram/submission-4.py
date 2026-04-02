class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False
        
        countS, countT = {}, {}

        for i in range(len(s)):
            currentS = s[i]
            currentT = t[i]

            if currentS in countS:
                countS[currentS] += 1
            else:
                countS[currentS] = 1

            if currentT in countT:
                countT[currentT] += 1
            else:
                countT[currentT] = 1


        for x in s:
            if x in countT:
                if countS[x] != countT[x]:
                    return False
            else:
                return False

            
        return True