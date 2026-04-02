class Solution {
    public int characterReplacement(String s, int k){
        Map<Character, Integer> count = new HashMap<>();

        int l = 0;
        int r = 0;

        int maxF = 0;
        int res = 0;

        while (r < s.length()){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1); // fixed here

            maxF = Math.max(maxF, count.get(s.charAt(r)));

            while ((r - l + 1) - maxF > k){
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}
