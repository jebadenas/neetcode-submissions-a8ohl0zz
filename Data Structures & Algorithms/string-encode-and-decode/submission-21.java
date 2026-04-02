class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s: strs){
            res.append(s.length());
            res.append("#");
            res.append(s);
        }
        System.out.println(res);
        return res.toString();
    }

    public List<String> decode(String str) {
        
        ArrayList<String> res = new ArrayList<>();

        int i = 0;

        while (i<str.length()){
            int length = 0;
            int j = i;

            while (str.charAt(j)!='#'){
                length++;
                j++;
            }

            length = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1, j+1+length);
            res.add(word);
            i = j+1+length;
            
            
        }


        return res;
    }
}
