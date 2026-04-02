class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s: strs){
            res.append(s.length());
            res.append("#");
            res.append(s);
        }
        
        return res.toString();
    }

    public List<String> decode(String str) {
        
        int l = 0;
        int r = 0;

        List<String> res = new ArrayList<>();

        while (r < str.length()){
            
            if (str.charAt(r) == '#'){
                int length = Integer.valueOf(str.substring(l, r));
                res.add(str.substring(r+1, r+1+length));
                r = r + 1 + length;
                l = r;
            }else{
                r++;
            }
            
        }


        return res;
    }
}
