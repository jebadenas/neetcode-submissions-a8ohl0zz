class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs){
            int[] characterCount = new int[26];

            for (char c: s.toCharArray()){
                //if character is "a", index = 0
                int index = c - 'a' ;
                characterCount[index]++;
            }

            String key = Arrays.toString(characterCount);
            System.out.println(key);

            anagrams.putIfAbsent(key, new ArrayList<>());
            anagrams.get(key).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
