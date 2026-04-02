class Solution {
    public boolean isPalindrome(String s) {
        // s = s.trim();

        int p = 0;
        int q = s.length()-1;

        while (p<q){
            while (p<q && !alphaNum(s.charAt(p))){
                p++;
            }
            while (p<q && !alphaNum(s.charAt(q))){
                q--;
            }
            if (Character.toLowerCase(s.charAt(p)) != Character.toLowerCase(s.charAt(q))){
                System.out.print(s.charAt(p));
                System.out.print(s.charAt(q));
                return false;
            }

            p++;
            q--;
        }

        return true;

        
    }

    public boolean alphaNum(char c){
            return (c >= 'A' && c <= 'Z' || c>= 'a' && c <= 'z' || c >= '0' && c <= '9');
        }
}
