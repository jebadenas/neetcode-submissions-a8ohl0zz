class Solution:
    def isAlphaNum(self, c: str) -> bool:
        return (ord("A") <= ord(c) <= ord("Z") or
        ord("a") <= ord(c) <= ord("z") or
        ord("0") <= ord(c) <= ord("9"))


    def isPalindrome(self, s: str) -> bool:
        
        p = 0 
        q = len(s) - 1

        while p < q:
            while p < q and not self.isAlphaNum(s[p]):
                p+=1
            while p < q and not self.isAlphaNum(s[q]):
                q-=1

            if s[p].lower() != s[q].lower():
                return False



            p+=1
            q-=1


        return True