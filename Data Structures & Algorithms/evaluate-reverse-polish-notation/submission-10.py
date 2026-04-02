class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        
        operators = "+-*/"
        stack =[]

        

        for token in tokens:
            if token in operators:
                print(stack)
                secondOperand = int(stack.pop())
                firstOperand = int(stack.pop())
                
                if token == "+":
                    stack.append(firstOperand + secondOperand)
                elif token == "-":
                    stack.append(firstOperand - secondOperand)
                elif token == "*":
                    stack.append(firstOperand * secondOperand)
                else:
                    
                    stack.append(int(firstOperand / secondOperand))
            else:
                stack.append(int(token))

        return stack[0]
                
    