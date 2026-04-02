class Solution:
    def isValid(self, s: str) -> bool:
        
        brackets = {')': '(', '}':'{', ']':'['}

        bracket_stack = []

        for i in range(len(s)):
            current_character = s[i]
            if current_character in brackets: #this means it is a closing bracket
                if bracket_stack and brackets[current_character] == bracket_stack[-1]: #last bracket in stack and current character are a matching pair in the dictionary
                    bracket_stack.pop()
                else: #invalid string (last bracket is not a matching pair)
                    return False
            else:
                bracket_stack.append(current_character)

        return True if not bracket_stack else False