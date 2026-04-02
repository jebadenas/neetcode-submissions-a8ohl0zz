class Solution:
    def isValid(self, s: str) -> bool:
        
        bracketStr = "(){}[]"
        bracketStack = []
        bracketDict = {")":"(", "}":"{", "]":"["}

        for char in s:
            
            if char in bracketDict and bracketStack:
                curBracket = bracketDict[char]
                recentBracket = bracketStack.pop()
                print(recentBracket, curBracket)
                if recentBracket != curBracket:
                    return False
            elif char in bracketStr:
                bracketStack.append(char)



        return not bracketStack