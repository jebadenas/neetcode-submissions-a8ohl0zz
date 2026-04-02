class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("")){
            return"";
        }
            
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();

        for (char c: t.toCharArray()){
            count.put(c, count.getOrDefault(c, 0)+1);
        }

        System.out.println(window);


        int have = 0;
        int need = count.size();
        int[] indices = {0,0};
        int minLen = Integer.MAX_VALUE;

        int l = 0;

        for (int r = 0; r < s.length(); r++){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0)+1);
            if (count.containsKey(s.charAt(r)) && window.get(s.charAt(r)).equals(count.get(s.charAt(r)))){
                have++;
            }

            while (have == need){
                if (r-l+1 < minLen){
                    minLen = r-l+1;
                    indices[0] = l;
                    indices[1] = r;
                }

                window.put(s.charAt(l), window.getOrDefault(s.charAt(l),0)-1);
                if (count.containsKey(s.charAt(l)) && window.get(s.charAt(l))<count.get(s.charAt(l))){
                    have--;
                }
                l++;
            }

        }
        


        return (minLen== Integer.MAX_VALUE) ? "" : s.substring(indices[0], indices[1]+1);
    }
}
