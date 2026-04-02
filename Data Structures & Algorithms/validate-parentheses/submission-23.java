class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> parentheses = new HashMap<>();
        parentheses.put(')', '(');
        parentheses.put(']', '[');
        parentheses.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){
            
            if (parentheses.containsKey(c)){
                
                
                if (stack.isEmpty() || stack.pop() != parentheses.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
            
            
        }

        
        return stack.size() == 0;

    }
}
