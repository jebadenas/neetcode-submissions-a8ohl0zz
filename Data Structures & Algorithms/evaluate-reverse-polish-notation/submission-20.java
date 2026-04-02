class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        List<String> operators = Arrays.asList("+","-", "*", "/");

        for (String s: tokens){
            if (operators.contains(s)){
                int secondOperand = Integer.parseInt(stack.pop());
                int firstOperand = Integer.parseInt(stack.pop());

                int result;

                if (s.equals("+")){
                    result = firstOperand + secondOperand;
                }else if (s.equals("-")){
                    result = firstOperand - secondOperand;
                }else if (s.equals("*")){
                    result = firstOperand * secondOperand;
                }else{
                    result = firstOperand / secondOperand;
                }
                System.out.println(result);
                stack.push(Integer.toString(result));
        
            }else{
                System.out.println(s);
            stack.push(s);
            }
            
        }

        return Integer.parseInt(stack.pop());
    }
}
